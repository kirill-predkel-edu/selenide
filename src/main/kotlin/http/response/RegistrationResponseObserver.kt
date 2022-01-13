package http.response

interface RegistrationResponseObserver {
  fun updateAuthUserCookie(newAuthUserToken: String)
}