package config.dynamic

import config.StubType
import converters.FileConverter
import wiremock.mockconfig.MockConfig

class DynamicContext {
  val raisedStubs: MutableMap<StubType, MockConfig> = mutableMapOf()

  inline fun <reified T : Any> geStubByConfigName(configName: StubType): T {
    val pathToResponse: String = raisedStubs[configName]?.responseFileName ?: throw IllegalStateException("Selected " +
        "mock isn't in the context")
    return FileConverter.jsonToObjectFromResources(pathToResponse)
  }

  fun removeMockConfigByName(stubName: StubType) {
    raisedStubs.remove(stubName)
  }

  fun addMockConfig(mock: MockConfig) {
    raisedStubs[mock.name] = mock
  }
}