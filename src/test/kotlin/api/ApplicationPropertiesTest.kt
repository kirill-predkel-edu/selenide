package api

import ApiBaseTest
import config.holder.ApplicationConfigurationHolder
import config.properties.TafSystemProperties
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ApplicationPropertiesTest : ApiBaseTest() {
  private val expectedHost: String = "https://es-delta.moneyman.ru"

  @BeforeEach
  fun setUp() {
    System.setProperty(TafSystemProperties.HOST, expectedHost)
    ApplicationConfigurationHolder.getApplicationConfiguration()
  }

  @Test
  fun `Verify configuration provides system properties`() {
    val actualHost = config.host
    assert(expectedHost == actualHost)
  }

  @AfterEach
  fun tearDown() {
    System.clearProperty(TafSystemProperties.HOST)
  }
}
