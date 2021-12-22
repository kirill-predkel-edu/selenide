import config.dynamic.DynamicContext
import config.dynamic.DynamicContextHolder
import config.holder.ApplicationConfigurationHolder
import config.model.ApplicationConfiguration
import driver.provider.WebDriverFactoryManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class BaseTest {
  lateinit var config: ApplicationConfiguration
  var dynamicContext = DynamicContextHolder.initContext(DynamicContext())

  @BeforeAll
  fun setup() {
    config = ApplicationConfigurationHolder.getApplicationConfiguration()!!
    WebDriverFactoryManager().setWebDriverFactory()
  }
}