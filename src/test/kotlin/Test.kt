import org.junit.jupiter.api.Test
import services.CrmLoginPageOperations

internal class Test : BaseTest() {

  @Test
  fun crmLogin() {
    CrmLoginPageOperations().apply {
      openPage(config.crm.host + config.crm.endpoint)
      inputEmail(config.user.login)
      inputPassword(config.user.password)
      inputCaptcha(config.user.captcha)
      clickSubmitButton()
    }
  }
}