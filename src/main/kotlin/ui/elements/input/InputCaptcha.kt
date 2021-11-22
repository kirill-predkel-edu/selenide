package ui.elements.input

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

object InputCaptcha {
  fun inputCaptcha(captchaInput: SelenideElement, textToInput: String) {
    captchaInput.shouldBe(Condition.visible, Condition.empty)
    captchaInput.value = textToInput
  }
}