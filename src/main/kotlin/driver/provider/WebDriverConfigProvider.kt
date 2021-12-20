package driver.provider

import driver.model.WebDriverConfiguration
import converters.FileConverter.yamlToObject

internal class WebDriverConfigProvider {
  private val configFilePath: String = "src/test/resources/webdriver-configuration.yaml"

  fun readConfiguration(): WebDriverConfiguration = yamlToObject(configFilePath, WebDriverConfiguration::class.java)
}