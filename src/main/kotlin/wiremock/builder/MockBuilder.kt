package wiremock.builder

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import wiremock.builder.ResponseBuilder.buildMockResponse
import wiremock.mockconfig.MockConfig

object MockBuilder {
  fun getMappingBuilder(mockConfig: MockConfig): MappingBuilder {
    val mockResponse = buildMockResponse(mockConfig)
    val mappingBuilder: MappingBuilder = WireMock
      .any(WireMock.urlMatching(mockConfig.mockEndpoint))
      .atPriority(mockConfig.priority)
    return mappingBuilder.willReturn(mockResponse)
  }
}