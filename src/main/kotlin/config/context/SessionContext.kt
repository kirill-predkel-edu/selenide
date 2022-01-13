package config.context

import http.response.RegistrationResponseObserver
import http.response.RetrofitResponse

class SessionContext {
  private var registrationResponseObservers: MutableList<RegistrationResponseObserver> = mutableListOf()

  private var authUser: String = ""
  private val authUserHeaderName = "AuthUser"

  fun getAuthUserCookie(): String = authUser

  fun setAuthUserCookie(response: RetrofitResponse) {
    response.getCookieByName(authUserHeaderName)?.let {
      authUser = it
      this.notifyAuthUserChanges(it)
    }
  }

  fun addRegistrationResponseObserver(observer: RegistrationResponseObserver) {
    registrationResponseObservers.add(observer)
  }

  private fun notifyAuthUserChanges(authUserToken: String) {
    registrationResponseObservers.forEach { it.updateAuthUserCookie(authUserToken) }
  }
}