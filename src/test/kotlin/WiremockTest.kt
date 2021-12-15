import http.services.crm.retrofit.CrmController
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import wiremock.WiremockServer

internal class WiremockTest : BaseWiremockTest() {

  @Test
  fun wiremockTest() {
    val crmLoginEndpoint = "/secure/rest/sign/in"
    val loginString =
      "{\"id\":1,\"userName\":\"Master Testov\",\"localizedRole\":\"Super Administrator\",\"roleId\":11,\"distribution\":null,\"online\":null,\"error\":null,\"expired\":false}"
    WiremockServer().addStubForEndpoint(crmLoginEndpoint)

    val controller = CrmController()
    val response = controller.postCrmLogin()
    val stringResponse = response.body()?.string()

    assertEquals(stringResponse, loginString)
  }
}