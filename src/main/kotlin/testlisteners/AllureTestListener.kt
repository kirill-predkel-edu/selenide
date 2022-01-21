package testlisteners

import io.qameta.allure.listener.TestLifecycleListener
import io.qameta.allure.model.TestResult
import mu.KotlinLogging

class AllureTestListener : TestLifecycleListener {
  private val logger = KotlinLogging.logger {}

  override fun afterTestStart(result: TestResult?) {
    logger.info { "${result?.name} test is successfully started" }
  }
}
