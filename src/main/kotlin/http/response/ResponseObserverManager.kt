package http.response

object ResponseObserverManager {
  private var registrationResponseObservers: MutableList<Observer> = mutableListOf()

  fun addRegistrationResponseObserver(observer: Observer) {
    registrationResponseObservers.add(observer)
  }

  fun notifyObservers() {
    registrationResponseObservers.forEach { it.update() }
  }
}