package http.services

import config.holder.ApplicationConfigurationHolder
import http.client.CustomOkHttpClient
import http.response.CustomHttpClientResponse

internal object RegistrationService {
  private val base_url = ApplicationConfigurationHolder.getApplicationConfiguration()!!.host
  private val registration_endpoint = ApplicationConfigurationHolder.getApplicationConfiguration()!!.registration.registrationEndpoint

  fun makeGetRegistrationCall(): CustomHttpClientResponse {
    val httpClient = CustomOkHttpClient.getClient()
    val response: CustomHttpClientResponse = httpClient.get(base_url + registration_endpoint)
    if (response.toString() == "") {
      throw IllegalStateException("Received response is empty")
    }
    return response
  }
}