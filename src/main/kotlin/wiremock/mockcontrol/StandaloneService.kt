package wiremock.mockcontrol

import wiremock.holder.CrmResponseMocksHolder
import wiremock.holder.CrmResponseMocksHolder.addMockToHolder
import wiremock.builder.MockBuilder
import wiremock.mockconfig.MockConfig
import wiremock.server.WiremockStandaloneServer

class StandaloneService {
  var client = WiremockStandaloneServer().wireMockClient
  private val mockIndexInHolder by lazy { addMockToHolder() }

  fun getMockIndex() = mockIndexInHolder

  fun registerMock(mockConfig: MockConfig) {
    val mappingBuilder = MockBuilder.getMappingBuilder(mockConfig)
    val stubMapping = client.register(mappingBuilder)
    mockConfig.apply {
      this.id = stubMapping.uuid
      this.stubMapping = stubMapping
    }
    isMockRegistered(mockConfig)
    addMockToHolder()
  }

  private fun isMockRegistered(mockConfig: MockConfig): Boolean {
    val registeredStub = client.getStubMapping(mockConfig.id).item
    return registeredStub.equals(mockConfig.stubMapping)
  }


    fun removeMock(mockConfig: MockConfig) {
      client.removeStubMapping(client.getStubMapping(mockConfig.id).item)
      CrmResponseMocksHolder.removeMockFromHolder(mockIndexInHolder)
    }
  }