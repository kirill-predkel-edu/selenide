package http.services.registration.retrofit

import http.response.RegistrationResponseObservable
import http.response.RetrofitResponse
import http.retrofit.RetrofitServiceBuilder

class RegistrationController(
  private var passedBaseUrl: String,
  private var service: RegistrationService = RetrofitServiceBuilder.buildService(passedBaseUrl)
) {

  fun getRegistrationResponse(): RetrofitResponse {
    val response = RetrofitResponse(service.getRegistrationStep().execute())
    RegistrationResponseObservable.notifyWatchers(response)
    return response
  }
}