package driver.provider
import driver.model.BrowserType
import driver.model.WebDriverConfiguration
import driver.model.WebDriverType

internal class WebDriverFactoryManager{
  fun setWebDriverFactory(webDriverConfiguration: WebDriverConfiguration): WebDriverDefaultFactory {
    return when (webDriverConfiguration.webDriverType) {
      WebDriverType.LOCAL ->
        return when (webDriverConfiguration.browserType) {
          BrowserType.FIREFOX -> FirefoxWebDriverFactory(webDriverConfiguration)
          BrowserType.CHROME -> ChromeWebDriverFactory(webDriverConfiguration)
        }
      WebDriverType.REMOTE -> TODO()
    }
  }
}
