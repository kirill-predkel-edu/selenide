package wiremock.server

import wiremock.mockcontrol.CustomClient

interface CustomWiremockServer {
  fun getClient(): CustomClient<*>
}