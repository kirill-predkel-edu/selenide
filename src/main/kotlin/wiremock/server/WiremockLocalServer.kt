package wiremock.server//package wiremock.mockcontrol
//
//import com.github.tomakehurst.wiremock.WireMockServer
//import com.github.tomakehurst.wiremock.client.WireMock
//import com.github.tomakehurst.wiremock.client.WireMock.urlMatching
//import com.github.tomakehurst.wiremock.core.WireMockConfiguration
//import wiremock.mockconfigs.MockConfig
//
//class WiremockLocalServer(private val mockConfig: MockConfig) {
//  private val wireMockServer: WireMockServer = WireMockServer(
//    WireMockConfiguration
//      .options()
//      .port(8082)
//  )
//
//  fun getWiremock() = wireMockServer
//
//  fun addStubForEndpoint() {
//    val mockResponse = ResponseBuilder.buildMockResponse(mockConfig)
//    wireMockServer.stubFor(
//      WireMock
//        .any(urlMatching(mockConfig.mockEndpoint))
//        .atPriority(mockConfig.priority)
//        .willReturn(mockResponse)
//    )
//  }
//
//  fun start() {
//    wireMockServer.start()
//  }
//
//  fun stop() {
//    wireMockServer.stop()
//  }
//}