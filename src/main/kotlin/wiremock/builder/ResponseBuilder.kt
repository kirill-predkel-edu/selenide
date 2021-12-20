package wiremock.builder

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import converters.FileConverter
import wiremock.mockconfig.MockConfig

object ResponseBuilder {
  fun buildMockResponse(mockConfig: MockConfig): ResponseDefinitionBuilder? {
    return mockConfig.let {
      WireMock.aResponse()
        .withStatus(mockConfig.statusCode)
        .withHeader("Content-Type", mockConfig.contentType)
        .withBody(FileConverter.jsonToString(mockConfig.responseFileName))
    }
  }
}