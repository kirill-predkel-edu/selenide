import config.BrowserType
import config.provider.WebDriverFactoryManager
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class BaseTest {

  @BeforeAll
  fun setup() {
    WebDriverFactoryManager.getWebDriverConfiguration(BrowserType.CHROME)
  }
}