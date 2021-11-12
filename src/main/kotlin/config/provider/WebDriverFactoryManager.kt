package config.provider

import config.BrowserType
import context.Context
import context.Context.timeoutAmount
import io.github.bonigarcia.wdm.WebDriverManager

object WebDriverFactoryManager {

  fun getWebDriverConfiguration(browserType: BrowserType) {
    YamlReader().readConfiguration(Context.webDriverConfigurationPath)

    var browser: String? = null
    browser = when (browserType) {
      BrowserType.CHROME -> "chrome"
      BrowserType.FIREFOX -> "firefox"
    }
    val wdm: WebDriverManager = WebDriverManager.getInstance(browser)
    timeoutAmount?.let { wdm.timeout(it) }
  }
}