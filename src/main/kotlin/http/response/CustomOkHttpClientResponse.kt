package http.response

import okhttp3.Response

class CustomOkHttpClientResponse(private val response: Response) : CustomHttpClientResponse {

  override fun getHeaderByName(headerName: String): String? {
    return response.headers[headerName]
  }
}