package wiremock

import BaseTest
import config.holder.ApplicationConfigurationHolder
import http.services.crm.retrofit.CrmController
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.LocalService
import wiremock.server.WiremockLocalServer

internal class WiremockTestWithLocalServer: BaseTest() {
  private val expectedLocalizedRole: String = "Super Administrator"
  private val expectedUserName: String = "Master Testov"
  private val expectedRoleId: Int = 11
  private val wiremockLocalServer: WiremockLocalServer = WiremockLocalServer()
  private val localService: LocalService = LocalService(wiremockLocalServer)

  @BeforeEach
  fun startServer() {
    wiremockLocalServer.startServer()
  }

  @AfterEach()
  fun stopServer() {
    wiremockLocalServer.stopServer()
    localService.removeMock(CrmLoginMockConfig)
  }

  @Test
  fun `Wiremock local server registered and removed stub`() {
    localService.registerMock(CrmLoginMockConfig)
    val wiremockBaseUrl: String? = ApplicationConfigurationHolder.getWiremockBaseURL()
    val response = CrmController(wiremockBaseUrl).postCrmLogin()
    response.apply {
      assertAll(
        { Assertions.assertEquals(expectedLocalizedRole, this.localizedRole) },
        { Assertions.assertEquals(expectedUserName, this.userName) },
        { Assertions.assertEquals(expectedRoleId, this.roleId) },
      )
    }
  }
}