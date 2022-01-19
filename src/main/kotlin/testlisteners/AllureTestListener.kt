package testlisteners

import com.codeborne.selenide.Selenide
import io.qameta.allure.listener.TestLifecycleListener
import io.qameta.allure.model.TestResult
import mu.KotlinLogging
import org.openqa.selenium.OutputType
import java.io.File

class AllureTestListener : TestLifecycleListener {
  private val logger = KotlinLogging.logger {}

  override fun afterTestStart(result: TestResult?) {
    logger.info { "Allure Test Listener After Start Callback" }
  }

  fun makeScreenshot(): File? = Selenide.screenshot(OutputType.FILE)
}