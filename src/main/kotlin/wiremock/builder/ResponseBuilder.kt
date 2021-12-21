package wiremock.builder

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import converters.FileConverter
import wiremock.mockconfig.MockConfig

object ResponseBuilder {
  fun buildMockResponse(mockConfig: MockConfig): ResponseDefinitionBuilder? {
    return mockConfig.run {
      WireMock.aResponse()
        .withStatus(this.statusCode)
        .withHeader("Content-Type", this.contentType)
        .withBody(FileConverter.jsonToString(this.responseFileName))
    }
  }
}