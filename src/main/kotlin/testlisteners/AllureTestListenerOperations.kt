package testlisteners

import io.qameta.allure.Allure
import io.qameta.allure.Attachment
import org.apache.commons.io.FileUtils

object AllureTestListenerOperations {
  private val allureTestListener = AllureTestListener()

  @Attachment
  fun addScreenshotToAllureRepost() {
    val screenshot = allureTestListener.makeScreenshot()
    Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshot))  }
}