package http.interceptors

import okhttp3.Interceptor
import okhttp3.Response

internal class ErrorStatusCodeInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val response: Response = chain.proceed(chain.request())
    if (response.code in 400..500) {
      throw IllegalStateException("Status code isn't successful. Received code is  ${response.code}")
    }
    return response
  }
}