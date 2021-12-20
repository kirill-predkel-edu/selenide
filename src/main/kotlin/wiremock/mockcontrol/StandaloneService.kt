package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import wiremock.builder.ResponseBuilder
import wiremock.mockconfig.MockConfig
import wiremock.server.WiremockStandaloneServer

class StandaloneService {
  var client = WiremockStandaloneServer().wireMockClient

  fun registerMock(mockConfig: MockConfig) {
    val mappingBuilder = addMockToEndpoint(mockConfig)
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

  private fun addMockToEndpoint(mockConfig: MockConfig): MappingBuilder? {
    val mockResponse = buildMock(mockConfig)
    return WireMock
      .any(WireMock.urlMatching(mockConfig.mockEndpoint))
      .atPriority(mockConfig.priority)
      .willReturn(mockResponse)
  }

  private fun buildMock(mockConfig: MockConfig): ResponseDefinitionBuilder? {
    return ResponseBuilder.buildMockResponse(mockConfig)
  }

    fun removeMock(mockConfig: MockConfig) {
      client.removeStubMapping(client.getStubMapping(mockConfig.id).item)
    }
  }