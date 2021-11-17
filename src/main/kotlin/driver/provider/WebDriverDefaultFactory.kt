package driver.provider

import com.codeborne.selenide.Configuration
import driver.model.WebDriverConfiguration

interface WebDriverDefaultFactory {
  fun configDriver()

  fun setSelenideDefaultDriverConfig(webDriverConfiguration: WebDriverConfiguration) {
    Configuration.browserSize = webDriverConfiguration.browserScreenSize
    Configuration.timeout = webDriverConfiguration.timeout
  }
}
