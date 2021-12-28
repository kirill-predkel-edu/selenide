package http.services.registration.retrofit

import http.response.RetrofitResponse
import http.retrofit.RetrofitServiceBuilder

class RegistrationController(
  private var passedBaseUrl: String,
  private var service: RegistrationService = RetrofitServiceBuilder.buildService(passedBaseUrl)
) {

  fun getRegistrationResponse(): RetrofitResponse {
    return RetrofitResponse(service.getRegistrationStep().execute())
  }
}