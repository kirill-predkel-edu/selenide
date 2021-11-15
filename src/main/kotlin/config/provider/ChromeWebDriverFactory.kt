package config.provider

import com.codeborne.selenide.Configuration
import config.BrowserType

class ChromeWebDriverFactory: WebDriverDefaultFactory {
  override fun configDriver() {
    Configuration.browser = BrowserType.CHROME.browserName
    setSelenideDefaultDriverConfig()
  }
}