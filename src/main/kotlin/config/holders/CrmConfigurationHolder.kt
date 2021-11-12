package config.holders

import config.model.CrmConfiguration

object CrmConfigurationHolder {
  private lateinit var crmConfigurationInstance: CrmConfiguration

  fun setCrmConfiguration(crmConfiguration: CrmConfiguration) {
    if (!this::crmConfigurationInstance.isInitialized) {
      crmConfigurationInstance = crmConfiguration
    }
  }

  fun getCrmConfiguration(): CrmConfiguration {
    return crmConfigurationInstance
  }
}