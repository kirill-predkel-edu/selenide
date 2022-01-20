package testlisteners

import mu.KotlinLogging
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher

class JunitTestListener : TestWatcher, BeforeAllCallback {
  private val logger = KotlinLogging.logger {}
  private val allureTestListener = AllureTestListener()

  override fun beforeAll(context: ExtensionContext?) {

    logger.info { "Junit Test Listener Before All Callback" }
  }

  override fun testFailed(context: ExtensionContext?, cause: Throwable?) {
    logger.error { "${context?.displayName} test is failed" }
    allureTestListener.addScreenshotToAllureReport()
  }
}