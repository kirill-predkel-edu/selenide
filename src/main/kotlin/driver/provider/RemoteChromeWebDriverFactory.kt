package driver.provider

import com.codeborne.selenide.Configuration
import driver.model.WebDriverConfiguration
import io.github.bonigarcia.wdm.WebDriverManager

internal class RemoteChromeWebDriverFactory() :
  WebDriverDefaultFactory {
  override fun configDriver(webDriverConfiguration: WebDriverConfiguration) {
    Configuration.remote =
      "http://${webDriverConfiguration.remoteDriverHost}:${webDriverConfiguration.remoteDriverPort}"
    Configuration.browser = webDriverConfiguration.browserType.browserName

    setSelenideDefaultDriverConfig(webDriverConfiguration)
    WebDriverManager.getInstance().setup()
  }
}