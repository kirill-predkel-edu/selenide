package ui.elements.button

import com.codeborne.selenide.Condition
import com.codeborne.selenide.SelenideElement

object Button {

  fun clickButton(button: SelenideElement) {
    button.shouldBe(Condition.visible, Condition.enabled)
    button.click()
  }
}