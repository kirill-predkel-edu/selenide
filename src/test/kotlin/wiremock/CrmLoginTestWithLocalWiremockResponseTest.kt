package wiremock

import BaseTest
import http.services.crm.retrofit.CrmController
import http.services.crm.retrofit.model.CrmResponse
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.LocalService
import wiremock.server.WiremockLocalServer

internal class CrmLoginTestWithLocalWiremockResponseTest : BaseTest() {
  private val wiremockLocalServer: WiremockLocalServer = WiremockLocalServer()
  private val localService: LocalService = LocalService(wiremockLocalServer)

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
    localService.registerMock(CrmLoginMockConfig)

    val mock = dynamicContext.geStubByConfigName<CrmResponse>(CrmLoginMockConfig.name)
    val expectedLocalizedRole: String? = mock.localizedRole
    val expectedUserName: String? = mock.userName
    val expectedRoleId: Int? = mock.roleId

    val wiremockBaseUrl: String = config.wiremockConfiguration.getWiremockBaseURL()
    val response = CrmController(wiremockBaseUrl).postCrmLogin(config.crm.crmUser)
    response.apply {
      assertAll(
        { Assertions.assertEquals(expectedLocalizedRole, this.localizedRole) },
        { Assertions.assertEquals(expectedUserName, this.userName) },
        { Assertions.assertEquals(expectedRoleId, this.roleId) }
      )
    }
  }
}