package config.provider

import com.codeborne.selenide.Configuration
import context.Context

interface WebDriverDefaultFactory {
  fun configDriver()

  fun setSelenideDefaultDriverConfig() {
    Configuration.browserSize = Context.browserScreenSize
    Configuration.timeout = Context.timeoutAmount
  }
}