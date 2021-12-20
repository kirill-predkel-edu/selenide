package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import config.holder.ApplicationConfigurationHolder
import wiremock.mockconfigs.MockConfig
import wiremock.mockcontrol.ResponseBuilder.buildMockResponse

class WiremockStandaloneServer(private val mockConfig: MockConfig) : CustomServer {
  override val wireMockHost = ApplicationConfigurationHolder.getApplicationConfiguration()!!.wiremockHost
  override val wiremockPort = ApplicationConfigurationHolder.getApplicationConfiguration()!!.wiremockPort
  override val wireMockClient by lazy { serverInit() }
  override val stubMapping: StubMapping? by lazy { registerService() }

  private fun serverInit() = WireMock(wireMockHost, wiremockPort)

  override fun registerService(): StubMapping? {
    val stubMapping = wireMockClient.register(getMappingBuilder())
    stubMapping.id = mockConfig.id
    return stubMapping
  }

  override fun verifyMock() {
    assert(stubMapping?.id == mockConfig.id) { "Mapping isn't initialized" }
  }

  override fun removeMock() {
    wireMockClient.removeStubMapping(stubMapping)
  }

  override fun getMappingBuilder(): MappingBuilder {
    val mockResponse = buildMockResponse(mockConfig)
    return WireMock
      .any(WireMock.urlMatching(mockConfig.mockEndpoint))
      .atPriority(mockConfig.priority)
      .willReturn(mockResponse)
  }
}