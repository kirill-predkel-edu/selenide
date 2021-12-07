package http.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.internal.concurrent.TaskRunner.Companion.logger
import java.lang.String

internal class LoggingInterceptor : Interceptor {
  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val requestTime = System.nanoTime()
    logger.info(
      String.format(
        "Sending request %s on %s%n%s",
        request.url, chain.connection(), request.headers
      )
    )
    val response: Response = chain.proceed(request)
    val responseTime = System.nanoTime()
    logger.info(
      String.format(
        "Received response for %s in %.1fms%n%s",
        response.request.url, (responseTime - requestTime) / 1e6, response.headers
      )
    )
    return response
  }
}