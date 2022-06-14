package http.operations

interface ResponseCookiesOperations {

  fun getCookieByName(cookieName: String): String? {
    val cookieHeaderName = "Set-Cookie"
    val cookiesDelimiter = ';'
    val cookieValueDelimiter = '='
    val cookieHeader: String? = getHeaderByName(cookieHeaderName)
    val mapWithCookies: Map<String, String>? = cookieHeader?.run {
      split(cookiesDelimiter)
        .map { it.split(cookieValueDelimiter) }
        .associate { it.first() to it.last() }
    }
    return mapWithCookies?.get(cookieName)
  }

  fun getHeaderByName(headerName: String): String?
}