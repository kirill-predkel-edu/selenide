package wiremock.mockconfig

import com.github.tomakehurst.wiremock.stubbing.StubMapping
import config.StubType
import converters.FileConverter
import http.services.crm.retrofit.model.CrmResponseStub
import http.services.crm.retrofit.model.Stub
import java.util.*

object CrmLoginMockConfig: MockConfig {
  override var id: UUID? = null
  override val priority: Int = 1
  override val mockEndpoint: String = "/secure/rest/sign/in"
  override val statusCode: Int = 200
  override val contentType: String = "application/json"
  override val responseFileName: String = "wiremock/mock-response.json"
  override var stubMapping: StubMapping? = null
  override var name: StubType = StubType.CRM_LOGIN_STUB
  override var content: Stub = FileConverter.jsonToObjectFromResources(responseFileName) as CrmResponseStub
}