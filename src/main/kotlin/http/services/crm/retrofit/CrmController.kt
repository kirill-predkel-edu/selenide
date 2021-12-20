package http.services.crm.retrofit

import config.holder.ApplicationConfigurationHolder
import http.retrofit.RetrofitServiceBuilder
import http.services.crm.retrofit.model.CrmResponse

class CrmController(private var baseUrl: String?) {
  private val config =  ApplicationConfigurationHolder.getApplicationConfiguration()!!
  private val loginService: CrmService by lazy { crmServiceInit(baseUrl) }

  private fun crmServiceInit(passedBaseUrl: String?): CrmService {
    var urlToGo: String = passedBaseUrl.orEmpty()
    if (urlToGo == "") {
      urlToGo = config.host
    }
    return RetrofitServiceBuilder.buildService(urlToGo)
  }

  fun postCrmLogin(): CrmResponse {
    return loginService.loginToCrm(config.crm.crmUser).execute().body() ?: throw IllegalStateException(
      "Login request can't be executed"
    )
  }
}
