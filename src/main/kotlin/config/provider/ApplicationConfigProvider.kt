package config.provider

import config.model.ApplicationConfiguration
import converters.FileConverter.yamlToObject

internal class ApplicationConfigProvider {
  private val configFilePath: String = "src/test/resources/application-configuration.yaml"

  fun readConfiguration(): ApplicationConfiguration = yamlToObject(configFilePath, ApplicationConfiguration::class.java)
}