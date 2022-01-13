import config.context.dynamic.DynamicContext
import config.context.dynamic.DynamicContextHolder
import config.holder.ApplicationConfigurationHolder
import config.model.ApplicationConfiguration
import driver.provider.WebDriverFactoryManager
import http.response.RegistrationResponseObservable
import http.response.RegistrationResponseObserver
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class BaseTest {
  lateinit var config: ApplicationConfiguration
  lateinit var dynamicContext: DynamicContext

  @BeforeAll
  fun setup() {
    DynamicContextHolder.initContext(DynamicContext())
    dynamicContext = DynamicContextHolder.getContext()
    RegistrationResponseObservable.addWatcher(dynamicContext)

    config = ApplicationConfigurationHolder.getApplicationConfiguration()!!

    WebDriverFactoryManager().setWebDriverFactory()
  }
}