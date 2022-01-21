package testlisteners

import com.codeborne.selenide.Selenide
import io.qameta.allure.Allure
import io.qameta.allure.Attachment
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import java.io.File

class AllureAttachments {
  private val logPath: String = "testFile.log"

  @Attachment
  fun addScreenshotToAllureReport() {
    val screenshot: File? = Selenide.screenshot(OutputType.FILE)
    Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshot))
  }

  @Attachment
  fun addLogToAllureReport() {
    val log = File(logPath)
    Allure.addAttachment("LogFile", FileUtils.openInputStream(log))
  }
}