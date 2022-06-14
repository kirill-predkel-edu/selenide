package http.services.crm.retrofit

import config.model.CrmUserConfiguration
import http.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import http.services.crm.retrofit.model.CrmResponseStub

internal interface CrmService : RetrofitService {
  @POST("/secure/rest/sign/in")
  fun loginToCrm(
    @Body body: CrmUserConfiguration
  ) : Call<CrmResponseStub>
}