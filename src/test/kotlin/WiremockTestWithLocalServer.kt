import http.services.crm.retrofit.CrmController
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.LocalService
import wiremock.server.WiremockLocalServer

internal class WiremockTestWithLocalServer : BaseWiremockTest() {
  private val expectedLocalizedRole: String = "Super Administrator"
  private val expectedUserName: String = "Master Testov"
  private val expectedRoleId: Int = 11
  private val server: WiremockLocalServer = WiremockLocalServer()
  private val client = server.wireMockServer
  private val localService: LocalService = LocalService(client)

  @BeforeEach
  fun startServer() {
    server.startServer()
  }

  @AfterEach()
  fun stopServer() {
    server.stopServer()
    localService.removeMock(CrmLoginMockConfig)
  }

  @Test
  fun wiremockTest() {
    localService.runLocalServer(CrmLoginMockConfig)

    val response = CrmController().postCrmLogin()
    response.apply {
      assertAll(
        { Assertions.assertEquals(expectedLocalizedRole, this.localizedRole) },
        { Assertions.assertEquals(expectedUserName, this.userName) },
        { Assertions.assertEquals(expectedRoleId, this.roleId) },
      )
    }
  }
}