package wiremock

import com.github.tomakehurst.wiremock.stubbing.StubMapping

object Holder {
  val setOfStubs: Set<StubMapping> ?= null

  fun addStubToHolder(stubMapping: StubMapping){
    setOfStubs?.plus(stubMapping)
  }
}