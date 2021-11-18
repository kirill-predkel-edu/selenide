package driver.provider

import driver.model.WebDriverConfiguration
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.Platform
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL

internal class RemoteChromeWebDriverFactory() :
  WebDriverDefaultFactory {
  override fun configDriver(webDriverConfiguration: WebDriverConfiguration) {
    val caps = DesiredCapabilities()
    caps.platform = Platform.WIN10
    caps.browserName = "chrome"
    RemoteWebDriver(URL("http://localhost:4444"), caps)

    setSelenideDefaultDriverConfig(webDriverConfiguration)
    WebDriverManager.getInstance().setup()
  }
}
