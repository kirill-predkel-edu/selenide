package config.context

interface ContextHolder<T> {
  val context: ThreadLocal<T>

  fun setContext(context: T) {
    if (this.context.get() == null) this.context.set(context)
  }
  fun getContext(): T = context.get() ?: throw IllegalStateException("Context isn't initialized")

  fun clearContext() = context.remove()

  fun initContext(context: T) {
    clearContext()
    setContext(context)
  }
}