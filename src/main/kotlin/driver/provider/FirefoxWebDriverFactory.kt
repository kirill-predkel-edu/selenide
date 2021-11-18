package driver.provider

import com.codeborne.selenide.Configuration
import driver.model.WebDriverConfiguration
import io.github.bonigarcia.wdm.WebDriverManager

internal class FirefoxWebDriverFactory() :
  WebDriverDefaultFactory {
  override fun configDriver(webDriverConfiguration: WebDriverConfiguration) {
    Configuration.browser = webDriverConfiguration.browserType.browserName
    setSelenideDefaultDriverConfig(webDriverConfiguration)
    WebDriverManager.getInstance().setup()
  }
}