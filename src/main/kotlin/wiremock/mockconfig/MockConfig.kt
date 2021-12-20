package wiremock.mockconfig

import com.github.tomakehurst.wiremock.stubbing.StubMapping
import java.util.*

interface MockConfig {
  var id: UUID?
  val priority: Int?
  val mockEndpoint: String?
  val statusCode: Int
  val contentType: String?
  val responseFileName: String?
  var stubMapping: StubMapping?
}