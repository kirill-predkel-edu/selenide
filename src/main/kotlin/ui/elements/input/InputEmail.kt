package ui.elements.input

import com.codeborne.selenide.SelenideElement

object InputEmail {
  fun inputEmail(emailInput: SelenideElement, textToInput: String) {
    emailInput.value = textToInput
  }
}