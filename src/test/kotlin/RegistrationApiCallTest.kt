import http.retrofit.RegistrationController
import http.services.RegistrationService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class RegistrationApiCallTest : BaseTest() {

  @Test
  fun `Make GET request and verify that AuthUser isn't null`() {
    val expectedAuthUserCookie = "AuthUser"
    val response = RegistrationService.makeGetRegistrationCall()
    val authUserCookie = response.getCookieByName(expectedAuthUserCookie)
    assertNotNull(authUserCookie)
  }

  @Test
  fun `Make GET  and verify that AuthUser isn't null`() {
    val controller = RegistrationController()
    val header = controller.getRegistrationHeaders()
    print(header)
  }
}
