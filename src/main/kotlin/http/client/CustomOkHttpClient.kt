package http.client

import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

class CustomOkHttpClient(private val client: OkHttpClient) : CustomHttpClient {

  override fun get(url: String, headers: Headers): Response {
    val request = Request.Builder()
      .url(url)
      .headers(headers)
      .build()
    return client.newCall(request).execute()
  }

  override fun post(url: String, headers: Headers, body: RequestBody): Response {
    val request = Request.Builder()
      .url(url)
      .headers(headers)
      .post(body)
      .build()
    return client.newCall(request).execute()
  }

  override fun delete(url: String, headers: Headers, body: RequestBody): Response {
    val request = Request.Builder()
      .url(url)
      .headers(headers)
      .delete(body)
      .build()
    return client.newCall(request).execute()
  }

  fun getCookies(headers: Headers): Map<String, String> {
    val cookieHeader = headers["Set-Cookie"]
    val mapWithCookies = cookieHeader!!.split(";")
      .map { it.split("=") }.associate { it.first() to it.last() }
    print(mapWithCookies)
    return mapWithCookies
  }
}