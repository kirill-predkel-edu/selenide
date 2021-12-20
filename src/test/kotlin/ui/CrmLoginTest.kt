package ui

import BaseTest
import org.junit.jupiter.api.Test
import services.CrmLoginPageOperations

internal class CrmLoginTest : BaseTest() {

  @Test
  fun `login in CRM with valid credentials`() {
    CrmLoginPageOperations().apply {
      openPage(config.host + config.crm.loginEndpoint)
      inputEmail(config.crm.crmUser.login)
      inputPassword(config.crm.crmUser.password)
      inputCaptcha(config.crm.crmUser.captcha)
      clickSubmitButton()
    }
  }
}