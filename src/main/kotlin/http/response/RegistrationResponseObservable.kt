package http.response

object RegistrationResponseObservable {
  private var list: MutableList<RegistrationResponseObserver> = mutableListOf()

  fun addWatcher(observer: RegistrationResponseObserver) {
    list.add(observer)
  }
  fun notifyWatchers(response: RetrofitResponse) {
    list.forEach { it.updateAuthUserCookie(response) }
  }
}