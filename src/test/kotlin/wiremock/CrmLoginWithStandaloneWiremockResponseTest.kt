package wiremock

import BaseTest
import http.services.crm.retrofit.CrmController
import http.services.crm.retrofit.model.CrmResponse
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.CustomWiremockService
import wiremock.server.WiremockStandaloneServer

internal class CrmLoginWithStandaloneWiremockResponseTest : BaseTest() {
  private val wiremockStandaloneServer: WiremockStandaloneServer = WiremockStandaloneServer()
  private val wiremockService: CustomWiremockService = CustomWiremockService(wiremockStandaloneServer)

  @AfterEach
  fun removeMock() {
    wiremockService.removeMock(CrmLoginMockConfig)
  }

  @Test
  fun `Login to CRM request returns response from Wiremock Standalone Server`() {
    wiremockService.registerMock(CrmLoginMockConfig)

    val mock = dynamicContext.geStubByConfigName<CrmResponse>(CrmLoginMockConfig.name)
    val expectedLocalizedRole: String? = mock.localizedRole
    val expectedUserName: String? = mock.userName
    val expectedRoleId: Int? = mock.roleId

    val wiremockBaseUrl: String = config.wiremockConfiguration.getWiremockBaseURL()
    val response: CrmResponse = CrmController(wiremockBaseUrl).postCrmLogin(config.crm.crmUser)
    response.apply {
      assertAll(
        { assertEquals(expectedLocalizedRole, this.localizedRole, "Received localized role isn't equal " +
            "to the expected one") },
        { assertEquals(expectedUserName, this.userName, "Received user name isn't equal " +
            "to the expected one") },
        { assertEquals(expectedRoleId, this.roleId,"Received role id isn't equal " +
            "to the expected one") },
      )
    }
  }
}