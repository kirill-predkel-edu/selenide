package http.services.registration.retrofit

import config.holder.ApplicationConfigurationHolder
import http.retrofit.RetrofitService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceBuilder {
  private val baseUrl: String = ApplicationConfigurationHolder.getApplicationConfiguration()!!.host

  fun getBaseUrl() = baseUrl

  inline fun <reified T : RetrofitService> buildService(): T {
    return Retrofit.Builder()
      .baseUrl(getBaseUrl())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(T::class.java)
  }
}