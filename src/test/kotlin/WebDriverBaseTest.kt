import config.context.dynamic.DynamicContext
import config.context.dynamic.DynamicContextHolder
import config.context.listener.EventTypes
import config.context.listener.ResponseListener
import config.context.sessionContext
import config.holder.ApplicationConfigurationHolder
import config.model.ApplicationConfiguration
import driver.provider.WebDriverFactoryManager
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class  WebDriverBaseTest {
  protected lateinit var config: ApplicationConfiguration

  @BeforeAll
  fun setup() {
    WebDriverFactoryManager().setWebDriverFactory()
    DynamicContextHolder.initContext(DynamicContext())

    config = ApplicationConfigurationHolder.getApplicationConfiguration()!!
  }

  @AfterAll
  fun cleanupOverallTestConfiguration() {
    DynamicContextHolder.clearContext()
  }
}