package wiremock.server

import com.github.tomakehurst.wiremock.client.WireMock
import config.holder.ApplicationConfigurationHolder

class WiremockStandaloneServer : CustomWiremockServer {
  override val wireMockClient by lazy { serverInit() }

  override fun serverInit(): WireMock {
    return ApplicationConfigurationHolder.getApplicationConfiguration()?.let { appConfig ->
      WireMock(appConfig.wiremockConfiguration.wiremockHost,
        appConfig.wiremockConfiguration.wiremockPort)
    }?: throw IllegalStateException("Application config isn't initialized")
  }
}