import http.services.crm.retrofit.CrmController
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
  fun wiremockTestWithStandalone() {
    val response = CrmController().postCrmLogin()
    response.apply {
      assertAll(
        { assertEquals(expectedLocalizedRole, this.localizedRole) },
        { assertEquals(expectedUserName, this.userName) },
        { assertEquals(expectedRoleId, this.roleId) },
      )
    }
  }
}