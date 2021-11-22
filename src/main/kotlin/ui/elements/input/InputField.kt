package ui.elements.input

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.SelenideElement

object InputField {
  fun inputField(fieldToInput: SelenideElement, textToInput: String) {
    fieldToInput.shouldBe(Condition.enabled, Condition.visible).click()
    fieldToInput.clear()
    sleep(500)
    fieldToInput.value = textToInput



  }
}