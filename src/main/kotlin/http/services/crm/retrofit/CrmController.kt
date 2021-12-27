package http.services.crm.retrofit

import config.model.CrmUserConfiguration
import http.retrofit.RetrofitServiceBuilder
import http.services.crm.retrofit.model.CrmResponse

internal class CrmController(
  private var passedBaseUrl: String,
  private var loginService: CrmService = RetrofitServiceBuilder.buildService(passedBaseUrl)
) {

  fun postCrmLogin(crmUser: CrmUserConfiguration): CrmResponse {
    return loginService.loginToCrm(crmUser).execute().body() ?: throw IllegalStateException(
      "Login request can't be executed"
    )
  }
}