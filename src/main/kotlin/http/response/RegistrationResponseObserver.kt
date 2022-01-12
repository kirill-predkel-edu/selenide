package http.response

import http.response.RetrofitResponse

interface RegistrationResponseObserver {
  fun makeActionWithResponse(response: RetrofitResponse)
}