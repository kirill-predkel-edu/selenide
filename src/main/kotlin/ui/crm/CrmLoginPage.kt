package ui.crm

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.SelenideElement
import org.openqa.selenium.By

class CrmLoginPage {
  private val emailField: SelenideElement = element(By.cssSelector("#username"))
  private val passwordField: SelenideElement = element(By.cssSelector("#password"))
  private val captchaField: SelenideElement = element(By.cssSelector("#captcha"))
  private val submitButton: SelenideElement = element(
    By.cssSelector(
      "#main > div > div.login-form > form > " +
          "div.login-submit-block > button"
    )
  )

  fun inputEmail(login: String?) {
    emailField.value = login
  }

  fun inputPassword(password: String?) {
    passwordField.value = password
  }

  fun inputCaptcha(captcha: String?) {
    captchaField.value = captcha
  }

  fun clickSubmitButton() {
    submitButton.click()
  }
}