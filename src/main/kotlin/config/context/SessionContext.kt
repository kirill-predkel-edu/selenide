package config.context

import http.response.RegistrationResponseObserver
import http.response.RetrofitResponse

class SessionContext: RegistrationResponseObserver {
  private var authUser: String = ""
  private val authUserHeaderName = "AuthUser"

  fun getAuthUserCookie(): String = authUser

  override fun updateAuthUserCookie(response: RetrofitResponse) {
    response.getCookieByName(authUserHeaderName)?.let {
      authUser = it
    }
  }
}