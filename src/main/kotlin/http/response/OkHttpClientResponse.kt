package http.response

import okhttp3.Response

class OkHttpClientResponse(private val response: Response) : CustomHttpClientResponse {

  override fun getCookieByName(cookieName: String): String? {
    val cookieHeader = getHeaderByName("Set-Cookie")
    val mapWithCookies = cookieHeader!!.split(";")
      .map { it.split("=") }.associate { it.first() to it.last() }
    print(mapWithCookies)
    return mapWithCookies[cookieName]
  }

  override fun getHeaderByName(headerName: String): String? {
    return response.headers[headerName]
  }
}