package config.context

import config.context.listener.EventManager
import config.context.listener.EventTypes
import http.response.RetrofitResponse

internal class SessionContext {
  var events: EventManager = EventManager()
  var authUser: String = ""

  var serviceResponse: RetrofitResponse? = null
    set(value) {
      field = value
      events.notify(EventTypes.NEW_RESPONSE)
    }
}