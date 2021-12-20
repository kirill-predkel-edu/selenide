package config.holder

import config.model.ApplicationConfiguration
import config.properties.TafSystemProperties.HOST
import config.provider.ApplicationConfigProvider

internal object ApplicationConfigurationHolder {
  private var applicationConfiguration: ApplicationConfiguration? = null

  fun getApplicationConfiguration(): ApplicationConfiguration? {
    if (applicationConfiguration == null) {
      applicationConfiguration = ApplicationConfigProvider().readConfiguration()
    }
    System.getProperty(HOST)?.apply {
      applicationConfiguration!!.host = this
    }
    return applicationConfiguration
  }

  fun getWiremockBaseURL(): String? {
    return applicationConfiguration?.let {
      it.wiremockConfiguration.wiremockProtocol +
          it.wiremockConfiguration.wiremockHost + ":" + it.wiremockConfiguration.wiremockPort
    }
  }
}