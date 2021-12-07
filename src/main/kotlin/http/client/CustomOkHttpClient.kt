package http.client

import http.response.OkHttpClientResponse
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

class CustomOkHttpClient(private val client: OkHttpClient) : CustomHttpClient {

  override fun get(url: String, headers: Headers): OkHttpClientResponse {
    val request = Request.Builder()
      .url(url)
      .headers(headers)
      .build()
    return OkHttpClientResponse(client.newCall(request).execute())
  }

  override fun post(url: String, headers: Headers, body: RequestBody): OkHttpClientResponse {
    val request = Request.Builder()
      .url(url)
      .headers(headers)
      .post(body)
      .build()
    return OkHttpClientResponse(client.newCall(request).execute())
  }

  override fun delete(url: String, headers: Headers, body: RequestBody): OkHttpClientResponse {
    val request = Request.Builder()
      .url(url)
      .headers(headers)
      .delete(body)
      .build()
    return OkHttpClientResponse(client.newCall(request).execute())
  }
}