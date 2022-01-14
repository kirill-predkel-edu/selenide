package config.context.dynamic

import config.context.SessionContext
import config.context.StubContext

internal class DynamicContext {
  val sessionContext = SessionContext()
  val stubContext = StubContext()

}