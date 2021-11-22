package ui.elements.input

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

object InputPassword {
  fun inputPassword(passwordInput: SelenideElement, textToInput: String) {
    passwordInput.shouldBe(Condition.visible, Condition.empty)
    passwordInput.value = textToInput
  }
}