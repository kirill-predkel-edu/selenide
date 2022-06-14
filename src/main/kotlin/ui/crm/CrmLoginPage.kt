package ui.crm

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By
import ui.elements.button.Button.clickButton
import ui.elements.input.InputField.inputField

internal class CrmLoginPage {
  private val emailField: SelenideElement = element(By.id("username"))
  private val passwordField: SelenideElement = element(By.id("password"))
  private val captchaField: SelenideElement = element(By.id("captcha"))
  private val submitButton: SelenideElement = element(By.cssSelector(".login-submit-block button"))

  fun openLoginPage(pageUrl: String) {
    open(pageUrl)
  }

  fun inputEmail(login: String) {
    inputField(emailField, login)
  }

  fun inputPassword(password: String) {
    inputField(passwordField, password)
  }

  fun inputCaptcha(captcha: String) {
    inputField(captchaField, captcha)
  }

  fun clickSubmitButton() {
    clickButton(submitButton)
  }
}