package config.context

import http.response.Observer
import http.response.ResponseObserverManager
import http.response.RetrofitResponse

internal class SessionContext : Observer {
  private var authUser: String = ""
  private val authUserHeaderName = "AuthUser"

  var serviceResponse: RetrofitResponse? = null
    set(value) {
      field = value
      ResponseObserverManager.notifyObservers()
    }

  fun getAuthUserCookie(): String = authUser

  override fun update() {
    val newAuthUser: String? = serviceResponse?.getCookieByName(authUserHeaderName)
    newAuthUser?.let {
      authUser = it
    }
  }
}