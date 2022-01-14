package config.context.observer

class EventManager(vararg events: EventTypes) {
  private var listeners: MutableMap<EventTypes, MutableList<EventListener>> = mutableMapOf()

  init {
    events.forEach {
      listeners[it] = mutableListOf()
    }
  }

  fun subscribe(eventType: EventTypes, listener: EventListener) {
    listeners[eventType]?.add(listener)
  }

  fun unsubscribe(eventType: EventTypes, listener: EventListener) {
    listeners[eventType]?.remove(listener)
  }

  fun notify(eventType: EventTypes) {
    listeners[eventType]?.forEach {
      it.update(eventType)
    }
  }
}