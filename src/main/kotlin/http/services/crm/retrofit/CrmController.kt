package http.services.crm.retrofit

import config.holder.ApplicationConfigurationHolder
import http.retrofit.RetrofitServiceBuilder
import http.services.crm.retrofit.model.CrmResponse

class CrmController(private var passedBaseUrl: String?) {
  private val config =  ApplicationConfigurationHolder.getApplicationConfiguration()!!
  private val loginService: CrmService by lazy { crmServiceInit() }

  private fun crmServiceInit(): CrmService {
    var baseUrl: String = passedBaseUrl.orEmpty()
    if (baseUrl == "") {
      baseUrl = config.host
    }
    return RetrofitServiceBuilder.buildService(baseUrl)
  }

  fun postCrmLogin(): CrmResponse {
    return loginService.loginToCrm(config.crm.crmUser).execute().body() ?: throw IllegalStateException(
      "Login request can't be executed"
    )
  }
}
