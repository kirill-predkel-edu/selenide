package driver.provider

import com.codeborne.selenide.Configuration
import config.BrowserType

class FirefoxWebDriverFactory: WebDriverDefaultFactory {
  override fun configDriver() {
    Configuration.browser = BrowserType.FIREFOX.browserName
    setSelenideDefaultDriverConfig()
  }
}