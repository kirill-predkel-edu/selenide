package wiremock.mockcontrol

import config.context.dynamic.DynamicContextHolder
import config.context.stubContext
import wiremock.builder.MockBuilder
import wiremock.mockconfig.MockConfig
import wiremock.server.CustomWiremockServer

class CustomWiremockService(server: CustomWiremockServer) {
  private val client = server.getClient()

  fun registerMock(mockConfig: MockConfig) {
    val mappingBuilder = MockBuilder.getMappingBuilder(mockConfig)
    val stubMapping = client.addStub(mappingBuilder)
    mockConfig.apply {
      this.id = stubMapping.uuid
      this.stubMapping = stubMapping
    }
    isMockRegistered(mockConfig)
    stubContext().addMockConfig(mockConfig)
  }

  private fun isMockRegistered(mockConfig: MockConfig) {
    val registeredStub = client.getStubMapping(mockConfig.id).item

    if (!registeredStub.equals(mockConfig.stubMapping)) {
      throw IllegalStateException ("Mock isn't initialized")
    }
  }

  fun removeMock(mockConfig: MockConfig) {
    client.removeStubMapping(client.getStubMapping(mockConfig.id).item)
    stubContext().removeMockConfigByName(mockConfig.name)
  }
}