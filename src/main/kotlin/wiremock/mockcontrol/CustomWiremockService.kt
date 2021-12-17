package wiremock.mockcontrol

import wiremock.mockconfigs.MockConfig

class CustomWiremockService {
  fun runStandaloneServer(mockConfig: MockConfig): CustomServer {
    val server = WiremockStandaloneServer(mockConfig)
    server.verifyMock()
    return server
  }

  fun removeStandaloneServiceStub(server: CustomServer) {
    server.removeMock()
  }
}