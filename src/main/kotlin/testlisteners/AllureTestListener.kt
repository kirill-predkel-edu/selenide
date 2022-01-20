package testlisteners

import com.codeborne.selenide.Selenide
import io.qameta.allure.Allure
import io.qameta.allure.Attachment
import io.qameta.allure.listener.TestLifecycleListener
import io.qameta.allure.model.TestResult
import mu.KotlinLogging
import org.apache.commons.io.FileUtils
import org.openqa.selenium.OutputType
import java.io.File

class AllureTestListener : TestLifecycleListener {
  private val logger = KotlinLogging.logger {}

  override fun afterTestStart(result: TestResult?) {
    logger.info { "Allure Test Listener After Start Callback" }
  }

  @Attachment
  fun addScreenshotToAllureReport() {
    val screenshot: File? = Selenide.screenshot(OutputType.FILE)
    Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshot))
  }
}
