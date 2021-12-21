package wiremock

import BaseTest
import config.holder.ApplicationConfigurationHolder
import http.services.crm.retrofit.CrmController
import http.services.crm.retrofit.model.CrmResponse
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.StandaloneService

internal class WiremockTestWithStandalone: BaseTest() {
  private val standaloneService: StandaloneService = StandaloneService()

  private val mock = CrmResponseMocksHolder.getMockFromHolder(standaloneService.getMockIndex())
  private val expectedLocalizedRole: String? = mock?.localizedRole
  private val expectedUserName: String? = mock?.userName
  private val expectedRoleId: Int? = mock?.roleId

  @BeforeEach
  fun startServer() {
    standaloneService.registerMock(CrmLoginMockConfig)
  }

  @AfterEach
  fun removeMock() {
    standaloneService.removeMock(CrmLoginMockConfig)
  }

  @Test
  fun `Login to CRM with wiremock standalone server`() {
    val wiremockBaseUrl: String = ApplicationConfigurationHolder.getWiremockBaseURL()!!
    val response: CrmResponse = CrmController(wiremockBaseUrl).postCrmLogin(config.crm.crmUser)
    response.apply {
      assertAll(
        { assertEquals(expectedLocalizedRole, this.localizedRole) },
        { assertEquals(expectedUserName, this.userName) },
        { assertEquals(expectedRoleId, this.roleId) }
      )
    }
  }
}