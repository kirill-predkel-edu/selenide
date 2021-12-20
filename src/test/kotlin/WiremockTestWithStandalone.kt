import http.services.crm.retrofit.CrmLoginService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfigs.CrmLoginMockConfig
import wiremock.mockcontrol.CustomWiremockService

internal class WiremockTestWithStandalone {
  private val expectedLocalizedRole: String = "Super Administrator"
  private val expectedUserName: String = "Master Testov"
  private val expectedRoleId: Int = 11

  @Test
  fun wiremockTestWithStandalone() {
    val service = CustomWiremockService()
    val client = service.runStandaloneServer(CrmLoginMockConfig)

    val response = CrmLoginService().postCrmLogin()
    response.apply {
      assertAll(
        { assertEquals(expectedLocalizedRole, this.localizedRole) },
        { assertEquals(expectedUserName, this.userName) },
        { assertEquals(expectedRoleId, this.roleId) },
      )
    }
    service.removeStandaloneServiceStub(client)
  }
}