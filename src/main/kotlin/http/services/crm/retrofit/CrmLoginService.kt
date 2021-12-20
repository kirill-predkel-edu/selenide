package http.services.crm.retrofit

import config.holder.ApplicationConfigurationHolder
import http.retrofit.RetrofitServiceBuilder
import http.services.crm.retrofit.model.CrmResponse

class CrmLoginService {
  private val crmUser = ApplicationConfigurationHolder.getApplicationConfiguration()!!.crm.crmUser
  private val loginService: CrmService by lazy { crmServiceInit() }
  private val loginWiremockService: CrmService by lazy { crmWiremockServiceInit() }

  private fun crmServiceInit(): CrmService {
    return RetrofitServiceBuilder.buildService()
  }

  private fun crmWiremockServiceInit(): CrmService {
    return RetrofitServiceBuilder.buildWiremockService()
  }

  fun postCrmLogin(): CrmResponse {
    return loginService.loginToCrm(crmUser).execute().body() ?: throw IllegalStateException(
      "Login request can't be executed"
    )
  }

  fun postCrmLoginWithWiremock(): CrmResponse {
    return loginWiremockService.loginToCrm(crmUser).execute().body() ?: throw IllegalStateException(
      "Login request can't be executed"
    )
  }
}
