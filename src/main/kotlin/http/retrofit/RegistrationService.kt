package http.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface RegistrationService: RetrofitService {
  @GET("/client-area/registration")
  fun getRegistrationHeaders(): Call<Headers>
}