package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping

interface CustomServer {
  val wireMockHost: String
  val wiremockPort: Int
  val wireMockClient: WireMock
  val stubMapping: StubMapping?
  fun registerService(): StubMapping?
  fun verifyMock()
  fun removeMock()
  fun getMappingBuilder(): MappingBuilder
}