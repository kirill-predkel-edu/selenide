package config.context.dynamic

import config.StubType
import config.context.SessionContext
import http.services.crm.retrofit.model.Stub
import wiremock.mockconfig.MockConfig

class DynamicContext {
  private val sessionContext = SessionContext()
  fun getSessionContext() = sessionContext

  //dynamic stub context
  private val raisedStubs: MutableMap<StubType, MockConfig> = mutableMapOf()

  fun geStubByConfigName(configName: StubType): Stub? {
    return raisedStubs[configName]?.content
  }

  fun removeMockConfigByName(stubName: StubType) {
    raisedStubs.remove(stubName)
  }

  fun addMockConfig(mock: MockConfig) {
    raisedStubs[mock.name] = mock
  }
}