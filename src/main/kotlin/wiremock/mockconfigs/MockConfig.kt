package wiremock.mockconfigs

import java.util.*

interface MockConfig {
  val id: UUID
  val priority: Int
  val mockEndpoint: String
  val statusCode: Int
  val contentType: String
  val responseFileName: String
}