import config.holders.ApplicationConfigurationHolder
import config.model.ApplicationConfiguration
import driver.configuration.WebDriverConfigurationHolder
import driver.provider.WebDriverFactoryManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class BaseTest {
  lateinit var config: ApplicationConfiguration

  @BeforeAll
  fun setup() {
    config = ApplicationConfigurationHolder.getApplicationConfiguration()!!
    WebDriverFactoryManager().setWebDriverFactory(WebDriverConfigurationHolder.getWebDriverConfiguration()!!).configDriver()
  }
}