package http.retrofit

import config.holder.ApplicationConfigurationHolder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceBuilder {
  private const val wiremockPort = ":8081"
  private val baseUrl: String = ApplicationConfigurationHolder.getApplicationConfiguration()!!.host

  fun getBaseUrl() = baseUrl + wiremockPort

  inline fun <reified T : RetrofitService> buildService(): T {
    return Retrofit.Builder()
      .baseUrl(getBaseUrl())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(T::class.java)
  }
}