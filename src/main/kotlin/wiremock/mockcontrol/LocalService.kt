package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import wiremock.builder.ResponseBuilder
import wiremock.mockconfig.MockConfig
import wiremock.server.WiremockLocalServer

class LocalService(server: WiremockLocalServer) {
  private val wiremockServer = server.getWiremockServer()

  fun registerMock(mockConfig: MockConfig) {
    val stubMapping = wiremockServer.stubFor(createMock(mockConfig))
    mockConfig.apply {
      this.id = stubMapping.uuid
      this.stubMapping = stubMapping
    }
    isMockRegistered(mockConfig)
  }

  private fun isMockRegistered(mockConfig: MockConfig): Boolean {
    val registeredStub = wiremockServer.getStubMapping(mockConfig.id).item

    return registeredStub.equals(mockConfig.stubMapping)
  }

  private fun createMock(mockConfig: MockConfig): MappingBuilder {
    val mockResponse = ResponseBuilder.buildMockResponse(mockConfig)
    return WireMock
      .any(WireMock.urlMatching(mockConfig.mockEndpoint))
      .atPriority(mockConfig.priority)
      .willReturn(mockResponse)
  }

  fun removeMock(mockConfig: MockConfig) {
    wiremockServer.removeStubMapping(wiremockServer.getStubMapping(mockConfig.id).item)
  }
}