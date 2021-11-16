package driver.provider

import driver.model.WebDriverConfiguration
import utils.YamlToObject.readYaml

internal class WebDriverConfigProvider {
  private val configFilePath: String = "src/test/resources/webdriver-configuration.yaml"

  fun readConfiguration(): WebDriverConfiguration = readYaml(configFilePath, WebDriverConfiguration::class.java)
}