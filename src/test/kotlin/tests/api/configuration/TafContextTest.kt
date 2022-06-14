package tests.api.configuration

import tests.basetests.ApiBaseTest
import config.context.getAuthUser
import http.response.RetrofitResponse
import http.services.registration.retrofit.RegistrationController
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TafContextTest : ApiBaseTest() {
  private val authUserHeaderName: String = "AuthUser"
  private lateinit var actualAuthUser: String
  private lateinit var expectedAuthUser: String
  private lateinit var controller: RegistrationController

  @BeforeEach
  fun initController() {
    controller = RegistrationController(config.host)
  }

  @Test
  fun `Store registration response to context and verify AuthUser token is stored by listener`() {
    val response: RetrofitResponse = controller.getRegistrationResponse()

    actualAuthUser = getAuthUser()
    expectedAuthUser = response.getCookieByName(authUserHeaderName).toString()

    assertEquals(
      expectedAuthUser, actualAuthUser,
      "AuthUser from context and response aren't equal"
    )
  }
}