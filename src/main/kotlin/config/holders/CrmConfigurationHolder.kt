package config.holders

import config.model.ApplicationConfiguration

object CrmConfigurationHolder {
  private lateinit var applicationConfigurationInstance: ApplicationConfiguration

  fun setCrmConfiguration(applicationConfiguration: ApplicationConfiguration) {
    if (!this::applicationConfigurationInstance.isInitialized) {
      applicationConfigurationInstance = applicationConfiguration
    }
  }

  fun getCrmConfiguration(): ApplicationConfiguration {
    return applicationConfigurationInstance
  }
}