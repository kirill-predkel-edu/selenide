package wiremock.mockcontrol

import wiremock.builder.MockBuilder
import wiremock.mockconfig.MockConfig
import wiremock.server.WiremockStandaloneServer

class StandaloneService {
  var client = WiremockStandaloneServer().wireMockClient

  fun registerMock(mockConfig: MockConfig) {
    val mappingBuilder = MockBuilder.getMappingBuilder(mockConfig)
    val stubMapping = client.register(mappingBuilder)
    mockConfig.apply {
      this.id = stubMapping.uuid
      this.stubMapping = stubMapping
    }
    isMockRegistered(mockConfig)
  }

  private fun isMockRegistered(mockConfig: MockConfig): Boolean {
    val registeredStub = client.getStubMapping(mockConfig.id).item
    return registeredStub.equals(mockConfig.stubMapping)
  }


    fun removeMock(mockConfig: MockConfig) {
      client.removeStubMapping(client.getStubMapping(mockConfig.id).item)
    }
  }