package config.context.dynamic

import config.context.ContextHolder

internal object DynamicContextHolder: ContextHolder<DynamicContext> {
  override val dynamicContext = ThreadLocal<DynamicContext>()
}