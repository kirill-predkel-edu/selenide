package http.response

object RegistrationResponseObservable {
  private var list: MutableList<RegistrationResponseObserver> = mutableListOf()

  fun addWatcher(observer: RegistrationResponseObserver) {
    list.add(observer)
  }
  fun notifyWatchers(authUserToken: String) {
    list.forEach { it.updateAuthUserCookie(authUserToken) }
  }
}