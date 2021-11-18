package config.holder

import config.model.ApplicationConfiguration
import config.provider.ApplicationConfigProvider

internal object ApplicationConfigurationHolder {
  private var applicationConfiguration: ApplicationConfiguration? = null

  fun getApplicationConfiguration(): ApplicationConfiguration? {
    if (applicationConfiguration == null) {
      applicationConfiguration = ApplicationConfigProvider().readConfiguration()
    }
    return applicationConfiguration
  }
}