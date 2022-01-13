import config.context.dynamic.DynamicContext
import config.context.dynamic.DynamicContextHolder
import config.context.sessionContext
import config.holder.ApplicationConfigurationHolder
import config.model.ApplicationConfiguration
import driver.provider.WebDriverFactoryManager
import http.response.ResponseObserverManager
import org.junit.jupiter.api.AfterAll
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
    ResponseObserverManager.addRegistrationResponseObserver(sessionContext())

    config = ApplicationConfigurationHolder.getApplicationConfiguration()!!

    WebDriverFactoryManager().setWebDriverFactory()
  }

  @AfterAll
  fun teardown() {
    DynamicContextHolder.clearContext()
  }
}