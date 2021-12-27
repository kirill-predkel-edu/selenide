package config.dynamic

import config.StubType
import http.services.crm.retrofit.model.Response
import wiremock.mockconfig.MockConfig

class DynamicContext {
  private val raisedStubs: MutableMap<StubType, MockConfig> = mutableMapOf()

  fun geStubByConfigName(configName: StubType): Response? {
    return raisedStubs[configName]?.content
  }

  fun removeMockConfigByName(stubName: StubType) {
    raisedStubs.remove(stubName)
  }

  fun addMockConfig(mock: MockConfig) {
    raisedStubs[mock.name] = mock
  }
}