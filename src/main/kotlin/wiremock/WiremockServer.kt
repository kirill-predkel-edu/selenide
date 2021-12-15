package wiremock

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock

class WiremockServer(private val wireMockServer: WireMockServer = WireMockServer()) {
  fun getWiremock() = wireMockServer

  fun configureWiremock() {
    WireMock.configureFor("localhost", 8081)
  }

  fun addStubForEndpoint(endpointUrl: String) {
    WireMock.stubFor(
      WireMock.post(endpointUrl)
        .atPriority(1)
        .willReturn(WireMock.aResponse().withBody("{\"id\":1,\"userName\":\"Master Testov\",\"localizedRole\":\"Super " +
            "Administrator\",\"roleId\":11,\"distribution\":null,\"online\":null,\"error\":null,\"expired\":false}"))
    )
  }
}