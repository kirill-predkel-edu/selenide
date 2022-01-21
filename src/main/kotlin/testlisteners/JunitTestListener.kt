package testlisteners

import annotations.DoNotExecute
import mu.KotlinLogging
import org.junit.jupiter.api.extension.ConditionEvaluationResult
import org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled
import org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled
import org.junit.jupiter.api.extension.ExecutionCondition
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher

class JunitTestListener : TestWatcher, ExecutionCondition {
  private val logger = KotlinLogging.logger {}
  private val allureAttachments = AllureAttachments()

  override fun testFailed(context: ExtensionContext?, cause: Throwable?) {
    logger.error { "${context?.displayName} test is failed" }
    allureAttachments.addScreenshotToAllureReport()
  }

  override fun testSuccessful(context: ExtensionContext?) {
    logger.info { "${context?.displayName} test is passed" }
    allureAttachments.addLogToAllureReport()
  }

  override fun evaluateExecutionCondition(context: ExtensionContext?): ConditionEvaluationResult {
    val isElementAnnotated  = context?.run { element.get().isAnnotationPresent(DoNotExecute::class.java) }
    return if (isElementAnnotated == true) {
      disabled("Test is disabled due to DoNotExecute annotation")
    } else enabled("ENABLED")
  }
}