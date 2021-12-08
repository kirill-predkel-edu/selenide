package http.client

import okhttp3.Interceptor
import okhttp3.OkHttpClient

class CustomOkHttpClientBuilder() {

  private var builder = OkHttpClient.Builder()

  fun build(): CustomOkHttpClient {
    return CustomOkHttpClient(builder.build())
  }

  fun addInterceptor(interceptor: Interceptor) {
    builder.addInterceptor(interceptor)
  }

  fun addInterceptors(interceptors: List<Interceptor>) {
    for (interceptor in interceptors) {
      builder.addInterceptor(interceptor)
    }
  }
}