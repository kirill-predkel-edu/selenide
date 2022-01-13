package http.response

object ResponseObserverManager {
  private var registrationResponseObservers: MutableList<RegistrationResponseObserver> = mutableListOf()

  fun addRegistrationResponseObserver(observer: RegistrationResponseObserver) {
    registrationResponseObservers.add(observer)
  }

  fun notifyAuthUserChanges(authUserToken: String) {
    registrationResponseObservers.forEach { it.updateAuthUserCookie(authUserToken) }
  }
}