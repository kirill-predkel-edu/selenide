package http.clients

import http.interceptors.BasicAuthInterceptor
import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response

class OkHttpClient : HttpClient {

  private val client = OkHttpClient.Builder()
    .addInterceptor(BasicAuthInterceptor("moneyman", "1005"))
    .build()

  override fun getClient(): OkHttpClient = client

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
    val test = cookieHeader!!.split(";")
      .map { it.split("=") }.associate { it.first() to it.last() }
    print(test)
    return test
  }
}