package wiremock.holder

import http.services.crm.retrofit.model.CrmResponse

object CrmResponseMocksHolder {
  private val arrayWithStabs: ArrayList<CrmResponse> = arrayListOf()

  fun addMockToHolder(): Int {
    val crmResponseMock = MockProvider.provideCrmResponseMock()
    arrayWithStabs.add(crmResponseMock)
    return arrayWithStabs.indexOf(crmResponseMock)
  }

  fun getMockFromHolder(index: Int): CrmResponse? {
    return arrayWithStabs.getOrNull(index)
  }

  fun removeMockFromHolder(index: Int) {
      arrayWithStabs.removeAt(index)
  }
}