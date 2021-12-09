import http.services.registration.retrofit.RegistrationController
import http.services.registration.okhttp.RegistrationService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class RegistrationApiCallTest : BaseTest() {

  @Test
  fun `Make GET request and verify that AuthUser isn't null`() {
    val expectedCookie = "AuthUser"
    val response = RegistrationService.makeGetRegistrationCall()
    val authUserCookie = response.getCookieByName(expectedCookie)
    assertNotNull(authUserCookie)
  }

  @Test
  fun `Retrofit - Make GET and verify that AuthUser isn't null`() {
    val expectedCookie = "AuthUser"
    val controller = RegistrationController()
    val headers = controller.getRegistrationHeaders()
    val authUserCookie = controller.getCookieByName(headers, expectedCookie)
    assertNotNull(authUserCookie)
  }
}