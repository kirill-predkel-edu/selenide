package wiremock

import BaseTest
import config.holder.ApplicationConfigurationHolder
import http.services.crm.retrofit.CrmController
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.holder.CrmResponseMocksHolder
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.LocalService
import wiremock.server.WiremockLocalServer

internal class WiremockTestWithLocalServer: BaseTest() {
  private val wiremockLocalServer: WiremockLocalServer = WiremockLocalServer()
  private val localService: LocalService = LocalService(wiremockLocalServer)

  private val mock = CrmResponseMocksHolder.getMockFromHolder(localService.getMockIndex())
  private val expectedLocalizedRole: String? = mock?.localizedRole
  private val expectedUserName: String? = mock?.userName
  private val expectedRoleId: Int? = mock?.roleId


  @BeforeEach
  fun startServer() {
    wiremockLocalServer.startServer()
  }

  @AfterEach()
  fun stopServer() {
    localService.removeMock(CrmLoginMockConfig)
    wiremockLocalServer.stopServer()
  }

  @Test
  fun `Login to CRM with wiremock local server`() {
    localService.registerMock(CrmLoginMockConfig)
    val wiremockBaseUrl: String = ApplicationConfigurationHolder.getWiremockBaseURL()!!
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