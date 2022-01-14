package config.context.observer

import config.context.sessionContext

class ResponseListener: EventListener {
  private val authUserHeaderName = "AuthUser"

  override fun update(eventType: EventTypes) {
    val newAuthUser: String? = sessionContext().serviceResponse?.getHeaderByName(authUserHeaderName)
    sessionContext().authUser = newAuthUser.toString()
  }
}