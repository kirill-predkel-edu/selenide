package ui.crm

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By
import ui.elements.button.Button
import ui.elements.input.InputField

internal class CrmLoginPageXPath {
  private val emailField: SelenideElement = element(By.xpath("//*[@id='username']"))
  private val passwordField: SelenideElement = element(By.xpath("//*[@id='password']"))
  private val captchaField: SelenideElement = element(By.xpath("//*[@id='captcha']"))
  private val submitButton: SelenideElement = element(By.xpath("//button[@type='submit']"))

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