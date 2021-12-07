package http.client

import http.response.CustomHttpClientResponse
import okhttp3.RequestBody
import okhttp3.internal.EMPTY_REQUEST

interface CustomHttpClient {

  fun get(url: String, headers: Map<String, String> = emptyMap()): CustomHttpClientResponse

  fun post(
    url: String,
    headers: Map<String, String> = emptyMap(),
    body: RequestBody = EMPTY_REQUEST
  ): CustomHttpClientResponse

  fun delete(
    url: String,
    headers: Map<String, String> = emptyMap(),
    body: RequestBody = EMPTY_REQUEST
  ): CustomHttpClientResponse
}