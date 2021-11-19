package ui.elements.input

import com.codeborne.selenide.SelenideElement

object InputPassword {
  fun inputPassword (passwordInput: SelenideElement, textToInput: String) {
    passwordInput.value = textToInput
  }
}