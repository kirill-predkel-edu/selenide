package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.WireMockServer
import config.dynamic.DynamicContextHolder
import wiremock.builder.MockBuilder
import wiremock.mockconfig.MockConfig
import wiremock.server.WiremockLocalServer

class LocalService(server: WiremockLocalServer) {
  private val wiremockServer: WireMockServer = server.getWiremockServer()
  private val context = DynamicContextHolder.getContext()

  fun registerMock(mockConfig: MockConfig) {
    val mappingBuilder = MockBuilder.getMappingBuilder(mockConfig)
    val stubMapping = wiremockServer.stubFor(mappingBuilder)
    mockConfig.apply {
      this.id = stubMapping.uuid
      this.stubMapping = stubMapping
    }
    isMockRegistered(mockConfig)
    context.addMockConfig(mockConfig)
  }

  private fun isMockRegistered(mockConfig: MockConfig): Boolean {
    val registeredStub = wiremockServer.getStubMapping(mockConfig.id).item
    return registeredStub.equals(mockConfig.stubMapping)
  }

  fun removeMock(mockConfig: MockConfig) {
    wiremockServer.removeStubMapping(wiremockServer.getStubMapping(mockConfig.id).item)
    context.removeMockConfigByName(mockConfig.name)
  }
}