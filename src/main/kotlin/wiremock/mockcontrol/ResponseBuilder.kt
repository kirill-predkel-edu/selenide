package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import converters.FileConverter
import wiremock.mockconfigs.MockConfig

object ResponseBuilder {
  fun buildMockResponse(mockConfig: MockConfig): ResponseDefinitionBuilder? {
    return mockConfig.statusCode?.let {
      WireMock.aResponse()
        .withStatus(it)
        .withHeader("Content-Type", mockConfig.contentType)
        .withBody(FileConverter.jsonToString(mockConfig.responseFileName))
    }
  }
}