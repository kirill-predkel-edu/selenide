package config.context.listener

class EventManager {
  private var listeners: MutableMap<EventTypes, MutableSet<EventListener>> = mutableMapOf()

  fun subscribe(eventType: EventTypes, vararg listener: EventListener) {
    listeners[eventType]?.addAll(listener) ?: this.listeners.put(eventType, mutableSetOf(*listener))
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