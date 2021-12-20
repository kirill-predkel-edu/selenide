package wiremock.server

import com.github.tomakehurst.wiremock.client.WireMock

interface CustomWiremockServer {
  val wireMockClient: WireMock
  fun serverInit(): WireMock
}