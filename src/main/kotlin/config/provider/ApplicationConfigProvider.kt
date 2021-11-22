package config.provider

import config.model.ApplicationConfiguration
import utils.YamlToObject.readYaml

internal class ApplicationConfigProvider {
  private val configFilePath: String = "src/test/resources/application-configuration.yaml"

  fun readConfiguration(): ApplicationConfiguration = readYaml(configFilePath, ApplicationConfiguration::class.java)
}