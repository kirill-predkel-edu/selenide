package basetests

import config.context.dynamic.DynamicContext
import config.context.dynamic.DynamicContextHolder
import driver.provider.WebDriverFactoryManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import testlisteners.JunitTestListener

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(JunitTestListener::class)
internal abstract class UiBaseTest : BaseTest() {

  @BeforeAll
  fun setup() {
    WebDriverFactoryManager().setWebDriverFactory()
    DynamicContextHolder.initContext(DynamicContext())
  }

  @AfterAll
  fun cleanupOverallTestConfiguration() {
    DynamicContextHolder.clearContext()
  }
}