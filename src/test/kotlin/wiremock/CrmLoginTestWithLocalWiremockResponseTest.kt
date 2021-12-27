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
import wiremock.server.WiremockLocalServer

internal class CrmLoginTestWithLocalWiremockResponseTest : BaseTest() {
  private val wiremockLocalServer: WiremockLocalServer = WiremockLocalServer()
  private val wiremockService: CustomWiremockService = CustomWiremockService(wiremockLocalServer)
  private lateinit var mock: CrmResponse
  private lateinit var wiremockBaseUrl: String
  private var expectedLocalizedRole: String? = null
  private var expectedUserName: String? = null
  private var expectedRoleId: Int? = null

  @BeforeEach
  fun startServer() {

    wiremockLocalServer.startServer()
    wiremockService.registerMock(CrmLoginMockConfig)
    wiremockBaseUrl = config.wiremockConfiguration.getWiremockBaseURL()

    mock = dynamicContext.geStubByConfigName(CrmLoginMockConfig.name)
    expectedLocalizedRole = mock.localizedRole
    expectedUserName = mock.userName
    expectedRoleId = mock.roleId
  }

  @AfterEach()
  fun stopServer() {
    wiremockLocalServer.stopServer()
  }

  @Test
  fun `Login to CRM request returns response from Wiremock Local Server`() {
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