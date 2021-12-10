package http.operations

interface ResponseCookiesOperations {
  fun getCookieByName(cookieName: String): String? {
    val cookieHeader: String? = getHeaderByName("Set-Cookie")
    val mapWithCookies: Map<String, String>? = cookieHeader?.run {
      split(";")
        .map { it.split("=") }
        .associate { it.first() to it.last() }
    }
    return mapWithCookies?.get(cookieName)
  }

  fun getHeaderByName(headerName: String): String?
}