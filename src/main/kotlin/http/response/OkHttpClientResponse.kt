package http.response

import okhttp3.Response

class OkHttpClientResponse(private val response: Response) {

  fun getCookieByName(cookieName: String): String? {
    val cookieHeader = response.headers["Set-Cookie"]
    val mapWithCookies = cookieHeader!!.split(";")
      .map { it.split("=") }.associate { it.first() to it.last() }
    print(mapWithCookies)
    return mapWithCookies[cookieName]
  }
}