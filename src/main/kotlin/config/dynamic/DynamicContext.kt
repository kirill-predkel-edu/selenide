package config.dynamic

import config.StubType
import converters.FileConverter
import wiremock.mockconfig.MockConfig

class DynamicContext {
  val raisedStubs: MutableList<MockConfig> = mutableListOf()

  private fun getMockConfigByName(configName: StubType): MockConfig {
    return raisedStubs.first { it.name == configName }
  }

  inline fun <reified T : Any> geStubByConfigName(configName: StubType): T {
    val pathToResponse: String = raisedStubs.first { it.name == configName }.responseFileName!!
    return FileConverter.jsonToObjectFromResources(pathToResponse)
  }

  fun removeMockConfigByName(stubName: StubType) {
    val mockToRemove = getMockConfigByName(stubName)
    raisedStubs.remove(mockToRemove)
  }

  fun addMockConfig(mock: MockConfig) {
    raisedStubs.add(mock)
  }
}