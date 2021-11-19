package ui.elements.button

import com.codeborne.selenide.SelenideElement

object SubmitButton {
  fun clickButton(button: SelenideElement) {
    button.click()
  }
}