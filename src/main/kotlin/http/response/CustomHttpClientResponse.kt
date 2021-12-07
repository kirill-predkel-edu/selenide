package http.response

interface CustomHttpClientResponse {
  fun getCookieByName(cookieName: String): String?
  fun getHeaderByName(headerName: String): String?
}