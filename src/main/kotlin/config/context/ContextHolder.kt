package config.context

interface ContextHolder<T> {
  val myContext: ThreadLocal<T>

  fun setContext(context: T) {
    if (myContext.get() == null) myContext.set(context)
  }
  fun getContext(): T = myContext.get() ?: throw IllegalStateException("Context isn't initialized")

  fun clearContext() = myContext.remove()

  fun initContext(context: T) {
    clearContext()
    setContext(context)
  }
}