package wiremock.server

import com.github.tomakehurst.wiremock.client.WireMock
import config.holder.ApplicationConfigurationHolder
import wiremock.mockcontrol.CustomMockClient

class WiremockStandaloneServer : CustomWiremockServer {
  private val wireMockClient: WireMock by lazy { serverInit() }

  override fun getClient(): CustomMockClient<WireMock> = CustomMockClient(wireMockClient)

  private fun serverInit(): WireMock {
    return ApplicationConfigurationHolder.getApplicationConfiguration()?.let { appConfig ->
      WireMock(appConfig.wiremockConfiguration.wiremockHost,
        appConfig.wiremockConfiguration.wiremockPort)
    }?: throw IllegalStateException("Application config isn't initialized")
  }
}