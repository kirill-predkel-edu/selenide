package http.retrofit

import config.holder.ApplicationConfigurationHolder
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
  fun isWiremockUrlUsing(url: String): Boolean {
    return url.equals(ApplicationConfigurationHolder.getWiremockBaseURL())
  }
}