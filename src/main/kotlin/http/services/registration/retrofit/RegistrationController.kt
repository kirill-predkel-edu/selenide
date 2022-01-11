package http.services.registration.retrofit

import config.context.dynamic.DynamicAuthUserContext
import config.context.dynamic.DynamicContextHolder
import http.response.RetrofitResponse
import http.retrofit.RetrofitServiceBuilder

class RegistrationController(
  private var passedBaseUrl: String,
  private var service: RegistrationService = RetrofitServiceBuilder.buildService(passedBaseUrl)
) {
  private val context = DynamicContextHolder.getContext() as DynamicAuthUserContext

  fun getRegistrationResponse(): RetrofitResponse {
    val response = RetrofitResponse(service.getRegistrationStep().execute())
    context.addAuthUserFromResponse(response)
    return response
  }
}