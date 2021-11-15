package config.provider

import config.BrowserType
import config.holders.WebDriverConfigurationHolder
import config.model.WebDriverConfiguration
import context.Context

open class WebDriverFactoryManager {

  open fun setWebDriverFactory(browserType: BrowserType): WebDriverDefaultFactory {

    return when (browserType) {
      BrowserType.CHROME -> ChromeWebDriverFactory()
      BrowserType.FIREFOX -> FirefoxWebDriverFactory()
    }
  }
}
