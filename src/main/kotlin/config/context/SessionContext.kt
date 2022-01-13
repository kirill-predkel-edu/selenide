package config.context

import http.response.RegistrationResponseObserver
import http.response.ResponseObserverManager
import http.response.RetrofitResponse

class SessionContext: RegistrationResponseObserver {

  private var authUser: String = ""
  private val authUserHeaderName = "AuthUser"

  fun getAuthUserCookie(): String = authUser

  fun receiveAuthUserCookie(response: RetrofitResponse) {
    val authUser = response.getCookieByName(authUserHeaderName)
    authUser?.let { ResponseObserverManager.notifyAuthUserChanges(it) }
    }

  override fun updateAuthUserCookie(newAuthUserToken: String) {
    authUser = newAuthUserToken
  }
}
