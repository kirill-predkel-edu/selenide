package wiremock.mockcontrol

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.stubbing.StubMapping
import wiremock.mockconfigs.MockConfig

interface CustomServer {
  val wireMockClient: WireMock
  fun registerService(mockConfig: MockConfig)
  fun isMockRegistered(mockConfig: MockConfig) : Boolean
  fun getMappingBuilder(mockConfig: MockConfig): MappingBuilder
}