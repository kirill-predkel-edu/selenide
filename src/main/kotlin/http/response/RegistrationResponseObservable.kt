package http.response

object RegistrationResponseObservable {
  private var list: MutableList<RegistrationResponseObserver> = mutableListOf()

  fun addWatcher(observer: RegistrationResponseObserver) {
    list.add(observer)
  }
  fun notifyWatchers(response: RetrofitResponse) {
    for (observer in list) {
      observer.makeActionWithResponse(response)
    }
  }
}