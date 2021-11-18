package driver.holder

import driver.model.WebDriverConfiguration
import driver.provider.WebDriverConfigProvider

internal object WebDriverConfigurationHolder {
  private var webDriverConfiguration: WebDriverConfiguration? = null

  fun getWebDriverConfiguration(): WebDriverConfiguration? {
    if (webDriverConfiguration == null) {
      webDriverConfiguration = WebDriverConfigProvider().readConfiguration()
    }
    return webDriverConfiguration
  }
}