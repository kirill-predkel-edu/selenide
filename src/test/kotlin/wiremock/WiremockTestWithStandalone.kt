package wiremock

import BaseTest
import http.services.crm.retrofit.CrmController
import http.services.crm.retrofit.model.CrmResponse
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import wiremock.mockconfig.CrmLoginMockConfig
import wiremock.mockcontrol.StandaloneService

internal class WiremockTestWithStandalone : BaseTest() {
  private val standaloneService: StandaloneService = StandaloneService()

  @AfterEach
  fun removeMock() {
    standaloneService.removeMock(CrmLoginMockConfig)
  }

  @Test
  fun `Login to CRM with wiremock standalone server`() {
    standaloneService.registerMock(CrmLoginMockConfig)

    val mock = dynamicContext.geStubByConfigName<CrmResponse>(CrmLoginMockConfig.name)
    val expectedLocalizedRole: String? = mock.localizedRole
    val expectedUserName: String? = mock.userName
    val expectedRoleId: Int? = mock.roleId

    val wiremockBaseUrl: String = config.wiremockConfiguration.getWiremockBaseURL()
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