package config.context.dynamic

import config.context.SessionContext
import config.context.StubContext

class DynamicContext {
  private val sessionContext = SessionContext()
  fun getSessionContext() = sessionContext

  private val stubContext = StubContext()
  fun getStubContext() = stubContext
}