package config.holders

import config.model.WebDriverConfiguration

object WebDriverConfigurationHolder {
  private lateinit var webDriverConfigurationInstance: WebDriverConfiguration

  fun setWebDriverConfiguration(webDriverConfiguration: WebDriverConfiguration) {
    if (!this::webDriverConfigurationInstance.isInitialized) {
      webDriverConfigurationInstance = webDriverConfiguration
    }
  }

  fun getWebDriverConfiguration(): WebDriverConfiguration {
    return webDriverConfigurationInstance
  }


}