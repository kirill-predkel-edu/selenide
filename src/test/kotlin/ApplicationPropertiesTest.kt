import config.holder.ApplicationConfigurationHolder
import config.properties.TafSystemProperties
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import services.CrmLoginPageOperations

internal class ApplicationPropertiesTest : BaseTest() {

  @BeforeEach
  fun setUp() {
    System.setProperty(TafSystemProperties.HOST, "https://es-delta.moneyman.ru")
    ApplicationConfigurationHolder.getApplicationConfiguration()
  }

  @Test
  fun `Verify configuration provides system properties`() {
    CrmLoginPageOperations().apply {
      openPage(config.host + config.crm.loginEndpoint)
      inputEmail(config.crm.crmUser.login)
      inputPassword(config.crm.crmUser.password)
      inputCaptcha(config.crm.crmUser.captcha)
      clickSubmitButton()
    }
  }

  @AfterEach
  fun tearDown() {
    System.clearProperty(TafSystemProperties.HOST)
  }
}