package http.response

interface RegistrationResponseObserver {
  fun updateAuthUserCookie(response: RetrofitResponse)
}