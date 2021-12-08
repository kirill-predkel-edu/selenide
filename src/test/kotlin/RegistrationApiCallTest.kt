import http.services.RegistrationService
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class RegistrationApiCallTest : BaseTest() {

  @Test
  fun `Make GET request and verify that AuthUser isn't null`() {
    val expectedAuthUserCookie = "AuthUser"
    val response = RegistrationService.makeGetRegistrationCall()
    assertNotNull(response)
    val authUserCookie = response.getCookieByName(expectedAuthUserCookie)
    assertNotNull(authUserCookie)
  }
}