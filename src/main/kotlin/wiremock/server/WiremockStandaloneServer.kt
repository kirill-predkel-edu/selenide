package wiremock.server

import com.github.tomakehurst.wiremock.client.WireMock
import config.holder.ApplicationConfigurationHolder

class WiremockStandaloneServer : CustomServer {
  override val wireMockClient by lazy { serverInit() }

  override fun serverInit(): WireMock {
    var wiremockHost: String? = null
    var wiremockPort = 8081
    ApplicationConfigurationHolder.getApplicationConfiguration()?.let {
      wiremockHost = it.wiremockHost
      wiremockPort = it.wiremockPort
    }
    return WireMock(wiremockHost, wiremockPort)
  }
}