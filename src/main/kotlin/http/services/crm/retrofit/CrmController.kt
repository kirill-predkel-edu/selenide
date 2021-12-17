package http.services.crm.retrofit

import config.holder.ApplicationConfigurationHolder
import http.retrofit.RetrofitServiceBuilder
import retrofit2.Response
import wiremock.model.CrmResponse

class CrmController {
  private val crmUser = ApplicationConfigurationHolder.getApplicationConfiguration()!!.crm.crmUser
  private val service: CrmService by lazy { crmServiceInit() }

  private fun crmServiceInit(): CrmService {
    return RetrofitServiceBuilder.buildService()
  }

  fun postCrmLogin(): Response<CrmResponse> {
    return service.loginToCrm(crmUser).execute()
  }
}