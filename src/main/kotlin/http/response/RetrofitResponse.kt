package http.response

import retrofit2.Response

class RetrofitResponse(private val response: Response<RetrofitResponse>) : CustomHttpClientResponse {

  override fun getHeaderByName(headerName: String): String? {
    return response.headers()[headerName]
  }
}