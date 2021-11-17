package driver.provider

import com.codeborne.selenide.Configuration
import driver.model.BrowserType
import driver.model.WebDriverConfiguration
import io.github.bonigarcia.wdm.WebDriverManager

internal class FirefoxWebDriverFactory(private var webDriverConfiguration: WebDriverConfiguration):
  WebDriverDefaultFactory {
  override fun configDriver() {
    Configuration.browser = webDriverConfiguration.browserType.browserName
    setSelenideDefaultDriverConfig(webDriverConfiguration)
    WebDriverManager.getInstance().setup()
  }
}