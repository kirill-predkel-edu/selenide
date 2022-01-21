package basetests

import config.holder.ApplicationConfigurationHolder
import config.model.ApplicationConfiguration
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import testlisteners.JunitTestListener

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(JunitTestListener::class)
internal abstract class BaseTest {
  protected lateinit var config: ApplicationConfiguration

  @BeforeAll
  fun initConfig() {
    config = ApplicationConfigurationHolder.getApplicationConfiguration()!!
  }
}