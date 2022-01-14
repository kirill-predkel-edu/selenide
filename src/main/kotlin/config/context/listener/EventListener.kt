package config.context.listener

interface EventListener {
  fun update(eventType: EventTypes)
}