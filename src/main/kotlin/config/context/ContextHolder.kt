package config.context

interface ContextHolder<T> {
  val dynamicContext: ThreadLocal<T>

  fun setContext(context: T) {
    if (dynamicContext.get() == null) dynamicContext.set(context)
  }
  fun getContext(): T = dynamicContext.get() ?: throw IllegalStateException("Context isn't initialized")

  fun clearContext() = dynamicContext.remove()

  fun initContext(context: T) {
    clearContext()
    setContext(context)
  }
}