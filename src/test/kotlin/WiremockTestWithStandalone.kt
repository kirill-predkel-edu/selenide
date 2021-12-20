import http.services.crm.retrofit.CrmLoginService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.StandaloneService

internal class WiremockTestWithStandalone {
  private val expectedLocalizedRole: String = "Super Administrator"
  private val expectedUserName: String = "Master Testov"
  private val expectedRoleId: Int = 11

  @Test
  fun wiremockTestWithStandalone() {
    val service = StandaloneService()
    service.runStandaloneServer(CrmLoginMockConfig)

    val response = CrmLoginService().postCrmLoginWithWiremock()
    response.apply {
      assertAll(
        { assertEquals(expectedLocalizedRole, this.localizedRole) },
        { assertEquals(expectedUserName, this.userName) },
        { assertEquals(expectedRoleId, this.roleId) },
      )
    }
    service.removeMock(CrmLoginMockConfig)
  }
}