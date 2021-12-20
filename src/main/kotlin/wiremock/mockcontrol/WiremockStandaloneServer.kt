package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import config.holder.ApplicationConfigurationHolder
import wiremock.mockconfigs.MockConfig
import wiremock.mockcontrol.ResponseBuilder.buildMockResponse

class WiremockStandaloneServer : CustomServer {
  override val wireMockClient by lazy { serverInit() }

  private fun serverInit(): WireMock {
    var wiremockHost: String? = null
    var wiremockPort = 8081
    ApplicationConfigurationHolder.getApplicationConfiguration()?.let {
      wiremockHost = it.wiremockHost
      wiremockPort = it.wiremockPort
    }
    return WireMock(wiremockHost, wiremockPort)
  }

  override fun registerService(mockConfig: MockConfig) {
    val stubMapping = wireMockClient.register(getMappingBuilder(mockConfig))
    mockConfig.apply {
      this.id = stubMapping.uuid
      this.stubMapping = stubMapping
    }
    isMockRegistered(mockConfig)
  }

  override fun isMockRegistered(mockConfig: MockConfig): Boolean {
    val registeredStub = wireMockClient.getStubMapping(mockConfig.id).item
    return registeredStub.equals(mockConfig.stubMapping)
  }

  fun removeMock(mockConfig: MockConfig) {
    wireMockClient.removeStubMapping(wireMockClient.getStubMapping(mockConfig.id).item)
  }

  override fun getMappingBuilder(mockConfig: MockConfig): MappingBuilder {
    val mockResponse = buildMockResponse(mockConfig)
    return WireMock
      .any(WireMock.urlMatching(mockConfig.mockEndpoint))
      .atPriority(mockConfig.priority)
      .willReturn(mockResponse)
  }
}