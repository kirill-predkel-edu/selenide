package wiremock.holder

import converters.FileConverter
import http.services.crm.retrofit.model.CrmResponse

object MockProvider {
  fun provideCrmResponseMock(): CrmResponse {
    return FileConverter.jsonToObject("src/test/resources/wiremock/mock-response.json")
  }
}