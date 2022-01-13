package config.context

import http.response.RegistrationResponseObservable
import http.response.RetrofitResponse

class SessionContext {
  private var authUser: String = ""
  private val authUserHeaderName = "AuthUser"

  fun getAuthUserCookie(): String = authUser

  fun setAuthUserCookie(response: RetrofitResponse) {
    response.getCookieByName(authUserHeaderName)?.let {
      authUser = it
      RegistrationResponseObservable.notifyWatchers(it)
    }
  }
}