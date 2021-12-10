package http.response

import retrofit2.Response

class RetrofitResponse(private val response: Response<RetrofitResponse>) : CustomHttpClientResponse {

  override fun getCookieByName(cookieName: String): String? {
    val cookieHeader = getHeaderByName("Set-Cookie") ?: throw NullPointerException("Cookies aren't found in response")
    val mapWithCookies = cookieHeader.split(";")
      .map { it.split("=") }.associate { it.first() to it.last() }
    return mapWithCookies[cookieName]
  }

  override fun getHeaderByName(headerName: String): String? {
    return response.headers()[headerName]
  }
}