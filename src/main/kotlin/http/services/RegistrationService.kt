package http.services

import config.holder.ApplicationConfigurationHolder
import http.client.CustomOkHttpClient
import http.response.CustomHttpClientResponse

object RegistrationService {
  private val httpClient = CustomOkHttpClient.getClient()
  private val base_url = ApplicationConfigurationHolder.getApplicationConfiguration()!!.host
  private val registration_endpoint = ApplicationConfigurationHolder.getApplicationConfiguration()!!.registration.registrationEndpoint

  fun makeGetRegistrationCall(): CustomHttpClientResponse {

    val response: CustomHttpClientResponse = httpClient.get(base_url + registration_endpoint)
    if (response.toString() == "") {
      throw IllegalStateException("Received response is empty")
    }
    return response
  }
}