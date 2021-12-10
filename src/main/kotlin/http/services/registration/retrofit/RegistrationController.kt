package http.services.registration.retrofit

import http.response.RetrofitResponse

class RegistrationController {
  private val service: RegistrationService by lazy { registrationServiceInit() }

  private fun registrationServiceInit(): RegistrationService {
    return RetrofitServiceBuilder.buildService()
  }

  fun getRegistrationResponse(): RetrofitResponse {
    return RetrofitResponse(service.getRegistrationStep().execute())
  }
}