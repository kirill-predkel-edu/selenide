package config.context.listener

class EventManager {
  private var listeners: MutableMap<EventTypes, MutableList<EventListener>> = mutableMapOf()


  fun subscribe(eventType: EventTypes, vararg listener: EventListener) {
    if (listeners[eventType] == null) {
      listeners[eventType] = mutableListOf(*listener)
    }
    else {
      listeners[eventType]?.addAll(listener) 
    }
  }

  fun unsubscribe(eventType: EventTypes, listener: EventListener) {
    listeners[eventType]?.remove(listener)
  }

  fun notify(eventType: EventTypes) {
    listeners[eventType]?.forEach { eventListener ->
      eventListener.update()
    }
  }
}