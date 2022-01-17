package api

import BaseTest
import config.context.getAuthUser
import http.response.RetrofitResponse
import http.services.registration.retrofit.RegistrationController
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class TafContextTest : BaseTest() {
  private val authUserHeaderName: String = "AuthUser"
  private lateinit var actualAuthUser: String
  private lateinit var expectedAuthUser: String
  private lateinit var controller: RegistrationController

  @BeforeEach
  fun initController() {
    controller = RegistrationController(config.host)
  }

  @Test
  fun `TAF Context - Store AuthUser to context and verify token is stored`() {
    val response: RetrofitResponse = controller.getRegistrationResponse()

    actualAuthUser = getAuthUser()
    expectedAuthUser = response.getCookieByName(authUserHeaderName).toString()

    assertEquals(
      expectedAuthUser, actualAuthUser,
      "AuthUser from context and response aren't equal"
    )
  }
}