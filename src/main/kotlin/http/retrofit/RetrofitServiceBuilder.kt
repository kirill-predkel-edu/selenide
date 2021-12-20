package http.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceBuilder {

  inline fun <reified T : RetrofitService> buildService(baseUrl: String): T {
    return Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(T::class.java)
  }
}