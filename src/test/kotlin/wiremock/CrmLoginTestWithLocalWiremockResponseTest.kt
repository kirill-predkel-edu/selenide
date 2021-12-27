package wiremock

import BaseTest
import http.services.crm.retrofit.CrmController
import http.services.crm.retrofit.model.CrmResponse
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.CustomWiremockService
import wiremock.server.WiremockLocalServer

internal class CrmLoginTestWithLocalWiremockResponseTest : BaseTest() {
  private val wiremockLocalServer: WiremockLocalServer = WiremockLocalServer()
  private val wiremockService: CustomWiremockService = CustomWiremockService(wiremockLocalServer)

  @BeforeEach
  fun startServer() {
    wiremockLocalServer.startServer()
  }

  @AfterEach()
  fun stopServer() {
    wiremockLocalServer.stopServer()
  }

  @Test
  fun `Login to CRM request returns response from Wiremock Local Server`() {
    wiremockService.registerMock(CrmLoginMockConfig)

    val mock = dynamicContext.geStubByConfigName<CrmResponse>(CrmLoginMockConfig.name)
    val expectedLocalizedRole: String? = mock.localizedRole
    val expectedUserName: String? = mock.userName
    val expectedRoleId: Int? = mock.roleId

    val wiremockBaseUrl: String = config.wiremockConfiguration.getWiremockBaseURL()
    val response = CrmController(wiremockBaseUrl).postCrmLogin(config.crm.crmUser)
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