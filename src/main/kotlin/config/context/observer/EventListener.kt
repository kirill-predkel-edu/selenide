package config.context.observer

interface EventListener {
  fun update(eventType: EventTypes)
}