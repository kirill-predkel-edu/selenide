package ui.elements.input

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

object InputEmail {
  fun inputEmail(emailInput: SelenideElement, textToInput: String) {
    emailInput.shouldBe(Condition.visible, Condition.empty)
    emailInput.value = textToInput
  }
}