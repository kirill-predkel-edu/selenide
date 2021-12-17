import http.services.crm.retrofit.CrmController
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import wiremock.mockconfigs.CrmLoginMockConfig
import wiremock.mockcontrol.CustomWiremockService

internal class WiremockTestWithStandalone {
  private val localizedRole: String = "Super Administrator"
  private val userName: String = "Master Testov"
  private val roleId: Int = 11

  @Test
  fun wiremockTestWithStandalone() {
    val service = CustomWiremockService()
    val client = service.runStandaloneServer(CrmLoginMockConfig)

    val controller = CrmController()
    val response = controller.postCrmLogin()

    val responseLocalizedRole: String? = response.body()?.localizedRole
    val responseUserName: String? = response.body()?.userName
    val responseRoleId: Int? = response.body()?.roleId
    assertEquals(localizedRole, responseLocalizedRole)
    assertEquals(userName, responseUserName)
    assertEquals(roleId, responseRoleId)

    service.removeStandaloneServiceStub(client)
  }
}