package ui.elements.input

import com.codeborne.selenide.SelenideElement

object InputCaptcha {
  fun inputCaptcha(inputCaptcha: SelenideElement, textToInput: String) {
    inputCaptcha.value = textToInput
  }
}