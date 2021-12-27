package wiremock

import BaseTest
import http.services.crm.retrofit.CrmController
import http.services.crm.retrofit.model.CrmResponse
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.CustomWiremockService
import wiremock.server.WiremockStandaloneServer

internal class CrmLoginWithStandaloneWiremockResponseTest : BaseTest() {
  private val wiremockStandaloneServer: WiremockStandaloneServer = WiremockStandaloneServer()
  private val wiremockService: CustomWiremockService = CustomWiremockService(wiremockStandaloneServer)
  private lateinit var mock: CrmResponse
  private lateinit var wiremockBaseUrl: String
  private var expectedLocalizedRole: String? = null
  private var expectedUserName: String? = null
  private var expectedRoleId: Int? = null

  @BeforeEach
  fun startServer() {
    wiremockBaseUrl = config.wiremockConfiguration.getWiremockBaseURL()

    mock = dynamicContext.geStubByConfigName(CrmLoginMockConfig.name)
    expectedLocalizedRole = mock.localizedRole
    expectedUserName = mock.userName
    expectedRoleId = mock.roleId
  }

  @AfterEach
  fun removeMock() {
    wiremockService.removeMock(CrmLoginMockConfig)
  }

  @Test
  fun `Login to CRM request returns response from Wiremock Standalone Server`() {
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