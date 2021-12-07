package http.client

import http.response.OkHttpClientResponse
import okhttp3.Headers
import okhttp3.RequestBody
import okhttp3.internal.EMPTY_HEADERS
import okhttp3.internal.EMPTY_REQUEST

interface CustomHttpClient {

  fun get(url: String, headers: Headers = EMPTY_HEADERS): OkHttpClientResponse

  fun post(url: String, headers: Headers, body: RequestBody = EMPTY_REQUEST): OkHttpClientResponse

  fun delete(url: String, headers: Headers, body: RequestBody = EMPTY_REQUEST): OkHttpClientResponse
}