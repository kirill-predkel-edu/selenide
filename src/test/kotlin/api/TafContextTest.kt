package api

import BaseTest
import config.context.getAuthUser
import http.response.RetrofitResponse
import http.services.registration.retrofit.RegistrationController
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class TafContextTest : BaseTest() {
  private val authUserHeaderName: String = "AuthUser"
  private lateinit var authUserCookieFromContext: String
  private lateinit var authUserCookieFromResponse: String

  @Test
  fun `TAF Context - Store AuthUser to context and verify token is stored`() {
    val controller = RegistrationController(config.host)
    val response: RetrofitResponse = controller.getRegistrationResponse()

    authUserCookieFromContext = getAuthUser().toString()
    authUserCookieFromResponse = response.getCookieByName(authUserHeaderName).toString()
    assertEquals(authUserCookieFromResponse, authUserCookieFromContext, "AuthUser from context and response aren't " +
        "equal")
  }
}