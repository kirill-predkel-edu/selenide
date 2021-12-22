package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.client.WireMock
import config.dynamic.DynamicContextHolder
import wiremock.builder.MockBuilder
import wiremock.mockconfig.MockConfig
import wiremock.server.WiremockStandaloneServer

class StandaloneService {
  var client: WireMock = WiremockStandaloneServer().wireMockClient
  private val context = DynamicContextHolder.getContext()

  fun registerMock(mockConfig: MockConfig) {
    val mappingBuilder = MockBuilder.getMappingBuilder(mockConfig)
    val stubMapping = client.register(mappingBuilder)
    mockConfig.apply {
      this.id = stubMapping.uuid
      this.stubMapping = stubMapping
    }
    isMockRegistered(mockConfig)
    context.addMockConfig(mockConfig)
  }

  private fun isMockRegistered(mockConfig: MockConfig): Boolean {
    val registeredStub = client.getStubMapping(mockConfig.id).item
    return registeredStub.equals(mockConfig.stubMapping)
  }

  fun removeMock(mockConfig: MockConfig) {
    client.removeStubMapping(client.getStubMapping(mockConfig.id).item)
    context.removeMockConfigByName(mockConfig.name)
  }
}