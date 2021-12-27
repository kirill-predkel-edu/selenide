package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.admin.model.SingleStubMappingResult
import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import java.util.*

class CustomClient<T>(private val client: T) {
  private val unknownClient: String = "Client isn't recognized"

  fun addStub(mappingBuilder: MappingBuilder): StubMapping {
    return when (client) {
      is WireMockServer -> client.stubFor(mappingBuilder)
      is WireMock -> client.register(mappingBuilder)
      else -> throw IllegalArgumentException(unknownClient)
    }
  }

  fun getStubMapping(id: UUID?): SingleStubMappingResult {
    return when (client) {
      is WireMockServer -> client.getStubMapping(id)
      is WireMock -> client.getStubMapping(id)
      else -> throw IllegalArgumentException(unknownClient)
    }
  }

  fun removeStubMapping(stubMapping: StubMapping) {
    return when (client) {
      is WireMockServer -> client.removeStubMapping(stubMapping)
      is WireMock -> client.removeStubMapping(stubMapping)
      else -> throw IllegalArgumentException(unknownClient)
    }
  }
}