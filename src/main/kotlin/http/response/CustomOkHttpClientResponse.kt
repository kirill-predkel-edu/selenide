package http.response

import okhttp3.Response

class CustomOkHttpClientResponse(private val response: Response) : CustomHttpClientResponse {

  override fun getCookieByName(cookieName: String): String? {
    val cookieHeader = getHeaderByName("Set-Cookie")
    val mapWithCookies = cookieHeader!!.split(";")
      .map { it.split("=") }.associate { it.first() to it.last() }
    return mapWithCookies[cookieName]
  }

  override fun getHeaderByName(headerName: String): String? {
    return response.headers[headerName]
  }

  override fun toString(): String {
    return response.toString()
  }
}