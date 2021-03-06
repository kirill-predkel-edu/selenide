package tests.ui.allure

import annotations.DoNotExecute
import tests.basetests.BaseTest
import org.junit.jupiter.api.Test
import services.CrmLoginPageOperations

internal class TestListenersTest : BaseTest() {

  @Test
  @DoNotExecute
  fun `Test with custom disable annotation isn't executed`() {
    CrmLoginPageOperations().apply {
      openPage(config.host)
      inputEmail(config.crm.crmUser.login)
    }
  }

  @Test
  fun `Screenshot is attached to Allure report on fail`() {
    CrmLoginPageOperations().apply {
      openPage(config.host)
      inputEmail(config.crm.crmUser.login)
    }
  }
}