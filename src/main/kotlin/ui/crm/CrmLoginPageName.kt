package ui.crm

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By
import ui.elements.button.Button
import ui.elements.input.InputField

internal class CrmLoginPageName {
  private val emailField: SelenideElement = element(By.name("username"))
  private val passwordField: SelenideElement = element(By.name("password"))
  private val captchaField: SelenideElement = element(By.cssSelector("#captcha"))
  private val submitButton: SelenideElement = element(By.cssSelector(".login-submit-block button"))

  fun openLoginPage(pageUrl: String) {
    open(pageUrl)
  }

  fun inputEmail(login: String) {
    InputField.inputField(emailField, login)
  }

  fun inputPassword(password: String) {
    InputField.inputField(passwordField, password)
  }

  fun inputCaptcha(captcha: String) {
    InputField.inputField(captchaField, captcha)
  }

  fun clickSubmitButton() {
    Button.clickButton(submitButton)
  }
}