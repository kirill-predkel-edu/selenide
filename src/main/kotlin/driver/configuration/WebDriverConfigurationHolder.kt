package driver.configuration

import driver.model.WebDriverConfiguration
import driver.provider.WebDriverConfigProvider

object WebDriverConfigurationHolder {
  private var webDriverConfiguration: WebDriverConfiguration? = null

  fun getWebDriverConfiguration(): WebDriverConfiguration? {
    if (webDriverConfiguration == null) {
      webDriverConfiguration = WebDriverConfigProvider().readConfiguration()
    }
    return webDriverConfiguration
  }
}