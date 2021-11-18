package driver.provider

import com.codeborne.selenide.Configuration
import driver.model.WebDriverConfiguration

internal interface WebDriverDefaultFactory {
  fun configDriver(webDriverConfiguration: WebDriverConfiguration)

  fun setSelenideDefaultDriverConfig(webDriverConfiguration: WebDriverConfiguration) {
    Configuration.browserSize = webDriverConfiguration.browserScreenSize
    Configuration.timeout = webDriverConfiguration.timeout
  }
}
