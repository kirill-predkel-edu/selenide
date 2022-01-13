package http.services.registration.retrofit

import config.context.sessionContext
import http.response.RetrofitResponse
import http.retrofit.RetrofitServiceBuilder

class RegistrationController(
  private var passedBaseUrl: String,
  private var service: RegistrationService = RetrofitServiceBuilder.buildService(passedBaseUrl)
) {

  fun getRegistrationResponse(): RetrofitResponse {
    val response = RetrofitResponse(service.getRegistrationStep().execute())
    sessionContext().receiveAuthUserCookie(response)
    return response
  }
}