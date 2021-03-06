package tests.api.wiremock

import tests.basetests.ApiBaseTest
import config.context.stubContext
import http.services.crm.retrofit.CrmController
import http.services.crm.retrofit.model.CrmResponseStub
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.CustomWiremockService
import wiremock.server.WiremockLocalServer

internal class CrmLoginTestWithLocalWiremockResponseTest : ApiBaseTest() {
  private val wiremockLocalServer: WiremockLocalServer = WiremockLocalServer()
  private val wiremockService: CustomWiremockService = CustomWiremockService(wiremockLocalServer)
  private lateinit var wiremockBaseUrl: String

  private lateinit var mock: CrmResponseStub
  private var expectedLocalizedRole: String? = null
  private var expectedUserName: String? = null
  private var expectedRoleId: Int? = null

  @BeforeEach
  fun startServer() {
    wiremockLocalServer.startServer()
    wiremockService.registerMock(CrmLoginMockConfig)
    wiremockBaseUrl = config.wiremockConfiguration.getWiremockBaseURL()

    mock = stubContext().geStubByConfigName(CrmLoginMockConfig.name) as CrmResponseStub
    expectedLocalizedRole = mock.localizedRole
    expectedUserName = mock.userName
    expectedRoleId = mock.roleId
  }

  @AfterEach
  fun stopServer() {
    wiremockLocalServer.stopServer()
  }

  @Test
  fun `Login to CRM request returns response from Wiremock Local Server`() {
    val response: CrmResponseStub = CrmController(wiremockBaseUrl).postCrmLogin(config.crm.crmUser)
    response.apply {
      assertAll(
        { assertEquals(expectedLocalizedRole, this.localizedRole,
          "Received localized role isn't equal to the expected one") },
        { assertEquals(expectedUserName, this.userName,
          "Received user name isn't equalto the expected one") },
        { assertEquals(expectedRoleId, this.roleId,
          "Received role id isn't equal to the expected one") },
      )
    }
  }
}