package services

import ui.crm.CrmLoginPage

class CrmLoginPageOperations {

  private val crmLoginPage = CrmLoginPage()

  fun openPage(pageUrl: String) {
    crmLoginPage.openLoginPage(pageUrl)
  }

  fun inputEmail(email: String) {
    crmLoginPage.inputEmail(email)
  }

  fun inputPassword(password: String) {
    crmLoginPage.inputPassword(password)
  }

  fun inputCaptcha(captcha: String) {
    crmLoginPage.inputCaptcha(captcha)
  }

  fun clickSubmitButton() {
    crmLoginPage.clickSubmitButton()
  }
}