package services

import ui.crm.CrmLoginPageCssSelectors
import ui.crm.CrmLoginPageId
import ui.crm.CrmLoginPageName
import ui.crm.CrmLoginPageXPath

class CrmLoginPageOperations {

  private val crmLoginPage = CrmLoginPageCssSelectors()

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