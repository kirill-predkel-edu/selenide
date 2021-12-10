package http.services.registration.retrofit

import http.response.RetrofitResponse
import http.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.http.GET

interface RegistrationService : RetrofitService {
  @GET("/client-area/registration")
  fun getRegistrationHeaders(): Call<RetrofitResponse>
}