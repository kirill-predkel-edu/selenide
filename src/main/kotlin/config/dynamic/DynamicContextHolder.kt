package config.dynamic

import config.context.ContextHolder

object DynamicContextHolder: ContextHolder<DynamicContext> {
  override val myContext = ThreadLocal<DynamicContext>()
}