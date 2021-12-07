import http.clients.OkHttpClient
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

internal class Registration : BaseTest() {

  @Test
  fun makeGetRequestAndVerifyAuthUserCookieTest() {
    val httpClient = OkHttpClient()
    val responseHeaders = httpClient.get(url = "https://es-charlie.moneyman.ru/client-area/registration").headers
    val responseCookies = httpClient.getCookies(responseHeaders)
    assertNotNull(responseCookies["AuthUser"])
  }
}
