package wiremock.mockconfig

import com.github.tomakehurst.wiremock.stubbing.StubMapping
import config.StubType
import http.services.crm.retrofit.model.Stub
import java.util.*

interface MockConfig {
  var id: UUID?
  val priority: Int?
  val mockEndpoint: String?
  val statusCode: Int
  val contentType: String?
  val responseFileName: String?
  var stubMapping: StubMapping?
  var name: StubType
  var content: Stub
}