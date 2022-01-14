package config.context

import config.context.observer.EventManager
import config.context.observer.EventTypes
import http.response.RetrofitResponse

internal class SessionContext {
  var events: EventManager = EventManager(EventTypes.NEW_RESPONSE)
  var authUser: String = ""

  var serviceResponse: RetrofitResponse? = null
    set(value) {
      field = value
      events.notify(EventTypes.NEW_RESPONSE)
    }
}