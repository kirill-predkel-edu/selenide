import config.context.listener.EventTypes
import config.context.listener.ResponseListener
import config.context.dynamic.DynamicContext
import config.context.dynamic.DynamicContextHolder
import config.context.sessionContext
import config.holder.ApplicationConfigurationHolder
import config.model.ApplicationConfiguration
import driver.provider.WebDriverFactoryManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class BaseTest {
  lateinit var config: ApplicationConfiguration

  @BeforeAll
  fun setup() {
    DynamicContextHolder.initContext(DynamicContext())
    sessionContext().events.subscribe(EventTypes.NEW_RESPONSE, ResponseListener())

    config = ApplicationConfigurationHolder.getApplicationConfiguration()!!

    WebDriverFactoryManager().setWebDriverFactory()
  }

  @AfterAll
  fun cleanupOverallTestConfiguration() {
    DynamicContextHolder.clearContext()
  }
}