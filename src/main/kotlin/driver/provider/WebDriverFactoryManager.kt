package driver.provider

import driver.holder.WebDriverConfigurationHolder
import driver.model.BrowserType
import driver.model.WebDriverType

internal class WebDriverFactoryManager {
  private val webDriverConfiguration = WebDriverConfigurationHolder.getWebDriverConfiguration()

  fun setWebDriverFactory() {
    webDriverConfiguration?.let { driverConfig ->
      when (driverConfig.webDriverType) {
        WebDriverType.LOCAL ->
          when (driverConfig.browserType) {
            BrowserType.FIREFOX -> FirefoxWebDriverFactory().configDriver(driverConfig)
            BrowserType.CHROME -> ChromeWebDriverFactory().configDriver(driverConfig)
          }
        WebDriverType.REMOTE -> RemoteChromeWebDriverFactory().configDriver(driverConfig)
      }
    } ?: throw IllegalStateException("WebDriver config isn't initialized")
  }
}
