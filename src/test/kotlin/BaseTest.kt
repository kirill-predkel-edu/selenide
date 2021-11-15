import config.BrowserType.CHROME
import config.provider.WebDriverFactoryManager
import config.provider.YamlReader
import context.Context
import io.github.bonigarcia.wdm.WebDriverManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class BaseTest {

  @BeforeAll
  fun setup() {
    val wvm: WebDriverManager = WebDriverManager.getInstance()
    YamlReader().readConfiguration(Context.webDriverConfigurationPath)
    YamlReader().readConfiguration(Context.crmConfigurationPath)
    WebDriverFactoryManager().setWebDriverFactory(CHROME).configDriver()
    wvm.setup()
  }
}