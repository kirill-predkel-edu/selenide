package http.retrofit

import config.holder.ApplicationConfigurationHolder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitServiceBuilder {

  private val wiremockHost = ApplicationConfigurationHolder.getApplicationConfiguration()!!.wiremockHost
  private val wiremockPort = ApplicationConfigurationHolder.getApplicationConfiguration()!!.wiremockPort
  private val wiremockProtocol = ApplicationConfigurationHolder.getApplicationConfiguration()!!.wiremockProtocol
  private val baseUrl: String = ApplicationConfigurationHolder.getApplicationConfiguration()!!.host

  fun getBaseUrl() = baseUrl
  fun getWiremockUrl() = "$wiremockProtocol$wiremockHost:$wiremockPort"

  inline fun <reified T : RetrofitService> buildService(): T {
    return Retrofit.Builder()
      .baseUrl(getBaseUrl())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(T::class.java)
  }

  inline fun <reified T : RetrofitService> buildWiremockService(): T {
    return Retrofit.Builder()
      .baseUrl(getWiremockUrl())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(T::class.java)
  }
}