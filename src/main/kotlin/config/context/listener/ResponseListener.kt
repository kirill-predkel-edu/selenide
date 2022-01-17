package config.context.listener

import config.context.sessionContext

class ResponseListener : EventListener {
  private val authUserHeaderName = "AuthUser"

  override fun update() {
    sessionContext().apply {
      serviceResponse?.getCookieByName(authUserHeaderName)?.also { authUser = it }
    }
  }
}