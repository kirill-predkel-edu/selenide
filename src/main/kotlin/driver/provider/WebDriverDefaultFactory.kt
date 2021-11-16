package driver.provider

import com.codeborne.selenide.Configuration
import config.holders.ApplicationConfigurationHolder
import driver.configuration.WebDriverConfigurationHolder

interface WebDriverDefaultFactory {
  fun configDriver()

  fun setSelenideDefaultDriverConfig() {
    WebDriverConfigurationHolder.getWebDriverConfiguration()?.let {
      Configuration.browserSize = it.browserScreenSize
      Configuration.timeout = it.timeout
    }
  }
}