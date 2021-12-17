//package wiremock
//
//import com.github.tomakehurst.wiremock.WireMockServer
//import com.github.tomakehurst.wiremock.client.WireMock
//import com.github.tomakehurst.wiremock.client.WireMock.urlMatching
//import com.github.tomakehurst.wiremock.core.WireMockConfiguration
//
//class CustomWiremockServer(
//  private val wireMockServer: WireMockServer = WireMockServer(WireMockConfiguration
//    .options()
//    .port(8081))) {
//
//  fun getWiremock() = wireMockServer
//
//  fun configureWiremock() {
//    WireMock.configureFor("localhost", 8081)
//
//
//    fun addStubForEndpoint(endpointUrl: String) {
//      WireMock.stubFor(
//        WireMock
//          .any(urlMatching(endpointUrl))
//          .atPriority(1)
//          .willReturn(
//            WireMock.aResponse()
//              .withStatus(200)
//              .withHeader("Content-Type", "application/json")
//              .withBodyFile("test.json")
//          )
//      )
//    }
//
//    fun start() {
//      wireMockServer.start()
//    }
//
//    fun stop() {
//      wireMockServer.stop()
//    }
//  }
//}