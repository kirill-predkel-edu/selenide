package config.context.dynamic

import http.response.RegistrationResponseObserver
import http.response.RetrofitResponse

class DynamicAuthUserContext : DynamicContext, RegistrationResponseObserver {

  private var authUser: String? = null
  private val authUserHeaderName = "AuthUser"

  fun getAuthUserCookie(): String? = authUser

  private fun addAuthUserFromResponse(response: RetrofitResponse) {
    val authUserFromResponse: String? = response.getCookieByName(authUserHeaderName)
    authUser = authUserFromResponse
  }

  override fun makeActionWithResponse(response: RetrofitResponse) {
    addAuthUserFromResponse(response)
  }
}