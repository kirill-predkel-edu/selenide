package testlisteners

import com.codeborne.selenide.Selenide
import io.qameta.allure.Allure
import io.qameta.allure.Attachment
import mu.KotlinLogging
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class AllureAttachments {
  private val logPath: String = "testFile.log"
  private val logger = KotlinLogging.logger {}

  @Attachment
  fun addScreenshotToAllureReport() {
    val screenshot: File? = Selenide.screenshot(OutputType.FILE)
    Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshot))
  }

  @Attachment
  fun addLogToAllureReport() {
    try {
      val log = File(logPath)
      Allure.addAttachment("LogFile", FileUtils.openInputStream(log))
    } catch (e: FileNotFoundException) {
      logger.error { "LogFile isn't found" }
    } catch (e: IOException) {
      logger.error { "LogFile can't be read" }
    }
  }
}