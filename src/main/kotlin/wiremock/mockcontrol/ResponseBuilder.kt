package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import utils.JsonToString
import wiremock.mockconfigs.MockConfig

object ResponseBuilder {
  fun buildMockResponse(mockConfig: MockConfig): ResponseDefinitionBuilder? {
    return WireMock.aResponse()
      .withStatus(mockConfig.statusCode)
      .withHeader("Content-Type", mockConfig.contentType)
      .withBody(JsonToString.readJson(mockConfig.responseFileName))
  }
}