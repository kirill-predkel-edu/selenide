package http.clients

import okhttp3.Headers
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.internal.EMPTY_HEADERS
import okhttp3.internal.EMPTY_REQUEST

interface HttpClient {
  fun getClient(): Any

  fun get(url: String, headers: Headers = EMPTY_HEADERS): Response

  fun post(url: String, headers: Headers, body: RequestBody = EMPTY_REQUEST): Response

  fun delete(url: String, headers: Headers, body: RequestBody = EMPTY_REQUEST): Response
}