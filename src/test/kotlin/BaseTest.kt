import config.context.dynamic.DynamicAuthUserContext
import config.context.dynamic.DynamicContextHolder
import config.context.dynamic.DynamicStubContext
import config.holder.ApplicationConfigurationHolder
import config.model.ApplicationConfiguration
import driver.provider.WebDriverFactoryManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class BaseTest {
  lateinit var config: ApplicationConfiguration
  var dynamicStubContext = DynamicContextHolder.initContext(DynamicStubContext()) as DynamicStubContext


  @BeforeAll
  fun setup() {
    config = ApplicationConfigurationHolder.getApplicationConfiguration()!!
    WebDriverFactoryManager().setWebDriverFactory()
    DynamicContextHolder.initContext(DynamicAuthUserContext())
  }
}