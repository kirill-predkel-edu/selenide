package wiremock.mockcontrol

import wiremock.mockconfigs.MockConfig

class CustomWiremockService(private val mockConfig: MockConfig) {
  private val server = WiremockStandaloneServer()

  fun runStandaloneServer() {
    server.registerService(mockConfig)
  }

  fun removeStandaloneServiceStub() {
   server.removeMock(mockConfig)
  }
}