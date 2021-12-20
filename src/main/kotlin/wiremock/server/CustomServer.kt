package wiremock.server

import com.github.tomakehurst.wiremock.client.WireMock

interface CustomServer {
  val wireMockClient: WireMock
  fun serverInit(): WireMock
}