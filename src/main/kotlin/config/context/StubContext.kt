package config.context

import config.StubType
import http.services.crm.retrofit.model.Stub
import wiremock.mockconfig.MockConfig

class StubContext {
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