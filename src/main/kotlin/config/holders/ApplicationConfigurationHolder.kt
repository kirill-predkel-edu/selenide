package config.holders

import config.model.ApplicationConfiguration
import config.provider.ApplicationConfigProvider

object ApplicationConfigurationHolder {
  private var applicationConfiguration: ApplicationConfiguration? = null

  fun getApplicationConfiguration(): ApplicationConfiguration? {
    if (applicationConfiguration == null) {
      applicationConfiguration = ApplicationConfigProvider().readConfiguration()
    }
    return applicationConfiguration
  }
}