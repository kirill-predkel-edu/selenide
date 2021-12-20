package http.services.crm.retrofit

import config.holder.ApplicationConfigurationHolder
import http.retrofit.RetrofitServiceBuilder
import http.services.crm.retrofit.model.CrmResponse

class CrmController {
  private val config =  ApplicationConfigurationHolder.getApplicationConfiguration()!!
  private val loginService: CrmService by lazy { crmServiceInit() }

  private fun crmServiceInit(): CrmService {
    return RetrofitServiceBuilder.buildService("http://localhost:8081")
  }

  fun postCrmLogin(): CrmResponse {
    return loginService.loginToCrm(config.crm.crmUser).execute().body() ?: throw IllegalStateException(
      "Login request can't be executed"
    )
  }
}
