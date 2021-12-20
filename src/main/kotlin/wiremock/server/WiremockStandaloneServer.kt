package wiremock.server

import com.github.tomakehurst.wiremock.client.WireMock
import config.holder.ApplicationConfigurationHolder

class WiremockStandaloneServer : CustomServer {
  override val wireMockClient by lazy { serverInit() }

  override fun serverInit(): WireMock {
    return ApplicationConfigurationHolder.getApplicationConfiguration()?.let { appConfig ->
      WireMock(appConfig.wiremockHost, appConfig.wiremockPort)
    }?: throw IllegalStateException("Get application config isn't initialized")
  }
}