package driver.provider

import config.BrowserType

class WebDriverFactoryManager {
  fun setWebDriverFactory(browserType: BrowserType): WebDriverDefaultFactory {
    return when (browserType) {
      BrowserType.CHROME -> ChromeWebDriverFactory()
      BrowserType.FIREFOX -> FirefoxWebDriverFactory()
    }
  }
}
