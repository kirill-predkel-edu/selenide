package http.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface RegistrationService : RetrofitService {
  @GET("/client-area/registration")
  fun getRegistrationCookies(): Call<okhttp3.Headers>
}