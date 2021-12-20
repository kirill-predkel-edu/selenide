package http.services.crm.retrofit

import config.holder.ApplicationConfigurationHolder
import http.retrofit.RetrofitServiceBuilder
import wiremock.model.CrmResponse

class CrmLoginService {
  private val crmUser = ApplicationConfigurationHolder.getApplicationConfiguration()!!.crm.crmUser
  private val service: CrmService by lazy { crmServiceInit() }

  private fun crmServiceInit(): CrmService {
    return RetrofitServiceBuilder.buildService()
  }

  fun postCrmLogin(): CrmResponse {
    return service.loginToCrm(crmUser).execute().body() ?: throw IllegalStateException(
      "Login request can't be " +
          "executed"
    )
  }
}