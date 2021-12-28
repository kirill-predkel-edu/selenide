package wiremock.server

import wiremock.mockcontrol.CustomMockClient

interface CustomWiremockServer {
  fun getClient(): CustomMockClient<*>
}