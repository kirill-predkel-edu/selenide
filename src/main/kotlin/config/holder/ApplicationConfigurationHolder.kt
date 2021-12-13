package config.holder

import config.properties.TafSystemProperties.HOST
import config.model.ApplicationConfiguration
import config.provider.ApplicationConfigProvider

internal object ApplicationConfigurationHolder {
  private var applicationConfiguration: ApplicationConfiguration? = null

  fun getApplicationConfiguration(): ApplicationConfiguration? {
    if (applicationConfiguration == null) {
      applicationConfiguration = ApplicationConfigProvider().readConfiguration()
    }
    if (System.getProperty(HOST)!=null) {
      applicationConfiguration!!.host = System.getProperty(HOST)
    }
    return applicationConfiguration
  }
}