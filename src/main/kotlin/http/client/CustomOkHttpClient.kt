package http.client

import config.holder.ApplicationConfigurationHolder
import config.model.BasicAuth
import http.interceptors.BasicAuthInterceptor
import http.interceptors.ErrorStatusCodeInterceptor
import http.interceptors.LoggingInterceptor
import http.response.CustomHttpClientResponse
import http.response.CustomOkHttpClientResponse
import okhttp3.Headers.Companion.toHeaders
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class CustomOkHttpClient(private val client: OkHttpClient) : CustomHttpClient {
  companion object {
    private val basicAuth: BasicAuth = ApplicationConfigurationHolder.getApplicationConfiguration()!!.basicAuth
    private val httpClient: CustomOkHttpClient by lazy { clientInit() }

    fun getClient(): CustomOkHttpClient {
      return httpClient
    }

    private fun clientInit(): CustomOkHttpClient {
      return CustomOkHttpClientBuilder().apply {
        addInterceptors(
          listOf(
            LoggingInterceptor(),
            BasicAuthInterceptor(basicAuth.login, basicAuth.password),
            ErrorStatusCodeInterceptor()
          )
        )
      }
        .build()
    }
  }

  override fun get(url: String, headers: Map<String, String>): CustomHttpClientResponse {
    val request = Request.Builder()
      .url(url)
      .headers(headers.toHeaders())
      .build()
    return CustomOkHttpClientResponse(client.newCall(request).execute())
  }

  override fun post(url: String, headers: Map<String, String>, body: RequestBody): CustomHttpClientResponse {
    val request = Request.Builder()
      .url(url)
      .headers(headers.toHeaders())
      .post(body)
      .build()
    return CustomOkHttpClientResponse(client.newCall(request).execute())
  }

  override fun delete(url: String, headers: Map<String, String>, body: RequestBody): CustomHttpClientResponse {
    val request = Request.Builder()
      .url(url)
      .headers(headers.toHeaders())
      .delete(body)
      .build()
    return CustomOkHttpClientResponse(client.newCall(request).execute())
  }
}