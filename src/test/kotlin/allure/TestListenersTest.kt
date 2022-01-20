package allure

import UiBaseTest
import org.junit.jupiter.api.Test
import services.CrmLoginPageOperations

internal class TestListenersTest : UiBaseTest() {

  @Test
  fun `Screenshot is attached to Allure report on fail`() {
    CrmLoginPageOperations().apply {
      openPage(config.host)
      inputEmail(config.crm.crmUser.login)
    }
  }
}