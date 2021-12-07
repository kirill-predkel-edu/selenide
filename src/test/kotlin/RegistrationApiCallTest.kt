import http.client.CustomOkHttpClientBuilder
import http.interceptors.BasicAuthInterceptor
import http.interceptors.ErrorStatusCodeInterceptor
import http.interceptors.LoggingInterceptor
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class RegistrationApiCallTest : BaseTest() {

  @Test
  fun `Make GET request and verify that AuthUser isn't null`() {
    val httpClient = CustomOkHttpClientBuilder().apply {
      addInterceptors(
        listOf(
          LoggingInterceptor(),
          BasicAuthInterceptor(config.basicAuth.login, config.basicAuth.password),
          ErrorStatusCodeInterceptor()
        )
      )
    }
      .build()
    val response = httpClient.get(url = config.host + config.registration.registrationEndpoint)
    assertNotNull(response)
    val authUserCookie = response.getCookieByName("AuthUser")
    assertNotNull(authUserCookie)
  }
}