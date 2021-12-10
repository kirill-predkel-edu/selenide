package http.services.registration.okhttp

import config.holder.ApplicationConfigurationHolder
import http.client.CustomOkHttpClient
import http.response.CustomHttpClientResponse

object RegistrationService {
  private val httpClient: CustomOkHttpClient = CustomOkHttpClient.getClient()
  private val base_url: String = ApplicationConfigurationHolder.getApplicationConfiguration()!!.host
  private val registration_endpoint: String = ApplicationConfigurationHolder
    .getApplicationConfiguration()!!
    .registration.registrationEndpoint

  fun makeGetRegistrationCall(): CustomHttpClientResponse {

    val response: CustomHttpClientResponse = httpClient.get(base_url + registration_endpoint)
    if (response.toString() == "") {
      throw IllegalStateException("Received response is empty")
    }
    return response
  }
}