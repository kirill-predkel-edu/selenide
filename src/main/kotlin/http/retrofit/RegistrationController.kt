package http.retrofit

import config.holder.ApplicationConfigurationHolder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegistrationController() {
  private val baseUrl= ApplicationConfigurationHolder.getApplicationConfiguration()!!.host
  private val service by lazy { registrationServiceInit() }

  private fun registrationServiceInit(): RegistrationService {
    return Retrofit.Builder()
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
      .create(RegistrationService::class.java)
  }

  fun getRegistrationHeaders(): String {
    return service.getRegistrationHeaders().execute().headers().toString()
  }
}