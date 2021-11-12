package config.provider

import config.holders.CrmConfigurationHolder
import config.holders.WebDriverConfigurationHolder
import context.Context.crmConfigurationPath

class YamlReader {
  private val CONFIG_RESOURCES_PATH: String = "src/main/resources/"

  fun readConfiguration(configurationPath: String) {
    if (configurationPath == crmConfigurationPath) CrmConfigurationHolder.setCrmConfiguration(
      YamlToObject.readYaml
        ("$CONFIG_RESOURCES_PATH$configurationPath")
    ) else WebDriverConfigurationHolder.setWebDriverConfiguration(
      YamlToObject.readYaml
        ("$CONFIG_RESOURCES_PATH$configurationPath")
    )
  }
}