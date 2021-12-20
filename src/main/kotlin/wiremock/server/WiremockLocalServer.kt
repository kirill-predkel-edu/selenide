package wiremock.server

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import config.holder.ApplicationConfigurationHolder

class WiremockLocalServer {
  private val wireMockServer by lazy { serverInit() }

  fun getWiremockServer() = wireMockServer

  private fun serverInit(): WireMockServer {
    return ApplicationConfigurationHolder.getApplicationConfiguration()?.let { appConfig ->
      WireMockServer(
        WireMockConfiguration
          .options()
          .port(appConfig.wiremockConfiguration.wiremockPort)
      )
    } ?: throw IllegalStateException("Application config isn't initialized")
  }

  fun startServer() {
    wireMockServer.start()
  }

  fun stopServer() {
    wireMockServer.stop()
  }
}