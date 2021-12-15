package http.services.crm.retrofit

import config.model.CrmUserConfiguration
import http.retrofit.RetrofitService
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CrmService : RetrofitService {
  @POST("/secure/rest/sign/in")
  fun loginToCrm(@Body body: CrmUserConfiguration): Call<ResponseBody>
}