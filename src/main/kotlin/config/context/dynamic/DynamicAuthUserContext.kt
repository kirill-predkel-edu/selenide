package config.context.dynamic

import http.response.RetrofitResponse

class DynamicAuthUserContext : DynamicContext {
  private var authUser: String? = null
  private val authUserHeaderName = "AuthUser"

  fun getAuthUserCookie(): String? = authUser

  fun addAuthUserFromResponse(response: RetrofitResponse) {
    val authUserFromResponse: String? = response.getCookieByName(authUserHeaderName)
    authUser = authUserFromResponse
  }
}