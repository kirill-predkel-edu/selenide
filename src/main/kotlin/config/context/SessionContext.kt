package config.context

import http.response.RegistrationResponseObserver
import http.response.ResponseObserverManager
import http.response.RetrofitResponse

class SessionContext : RegistrationResponseObserver {
  private var authUser: String = ""
  private val authUserHeaderName = "AuthUser"

  var serviceResponse: RetrofitResponse? = null
    set(value) {
      field = value
      ResponseObserverManager.notifyListeners()
    }

  fun getAuthUserCookie(): String = authUser

  override fun updateAuthUserCookie() {
    val newAuthUser: String? = serviceResponse?.getCookieByName(authUserHeaderName)
    newAuthUser?.let {
      authUser = it
    }
  }
}