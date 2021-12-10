import http.response.RetrofitResponse
import http.services.registration.okhttp.RegistrationService
import http.services.registration.retrofit.RegistrationController
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class RegistrationApiCallTest : BaseTest() {
  private val expectedCookie: String = "AuthUser"

  @Test
  fun `Make GET request and verify that AuthUser isn't null`() {
    val response = RegistrationService.makeGetRegistrationCall()
    val authUserCookie: String? = response.getCookieByName(expectedCookie)
    assertNotNull(authUserCookie)
  }

  @Test
  fun `Retrofit - Make GET request and verify that AuthUser isn't null`() {
    val controller = RegistrationController()
    val response: RetrofitResponse = controller.getRegistrationResponse()
    val authUserCookie: String? = response.getCookieByName(expectedCookie)
    println(authUserCookie)
    assertNotNull(authUserCookie)
  }
}