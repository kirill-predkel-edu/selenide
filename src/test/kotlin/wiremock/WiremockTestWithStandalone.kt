package wiremock

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

internal class WiremockTestWithStandalone {
  private val expectedLocalizedRole: String = "Super Administrator"
  private val expectedUserName: String = "Master Testov"
  private val expectedRoleId: Int = 11
  private val service: StandaloneService = StandaloneService()

  @BeforeEach
  fun startServer() {
    service.registerMock(CrmLoginMockConfig)
  }

  @AfterEach
  fun removeMock() {
    service.removeMock(CrmLoginMockConfig)
  }

  @Test
  fun `Wiremock standalone server registered and removed stub`() {
    val wiremockBaseUrl: String? = ApplicationConfigurationHolder.getWiremockBaseURL()
    val response: CrmResponse = CrmController(wiremockBaseUrl).postCrmLogin()
    response.apply {
      assertAll(
        { assertEquals(expectedLocalizedRole, this.localizedRole) },
        { assertEquals(expectedUserName, this.userName) },
        { assertEquals(expectedRoleId, this.roleId) },
      )
    }
  }
}