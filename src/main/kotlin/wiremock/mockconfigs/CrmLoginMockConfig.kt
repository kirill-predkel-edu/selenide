package wiremock.mockconfigs

import java.util.*

object CrmLoginMockConfig: MockConfig {
  override val id: UUID = UUID.randomUUID()
  override val priority: Int = 1
  override val mockEndpoint: String = "/secure/rest/sign/in"
  override val statusCode: Int = 200
  override val contentType: String = "application/json"
  override val responseFileName: String = "mock-response.json"
}