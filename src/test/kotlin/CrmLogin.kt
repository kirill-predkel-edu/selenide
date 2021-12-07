import org.junit.jupiter.api.Test
import services.CrmLoginPageOperations

internal class CrmLogin : BaseTest() {

  @Test
  fun crmLoginWithValidCredentialsTest() {
    CrmLoginPageOperations().apply {
      openPage(config.host + config.crm.loginEndpoint)
      inputEmail(config.crm.crmUser.login)
      inputPassword(config.crm.crmUser.password)
      inputCaptcha(config.crm.crmUser.captcha)
      clickSubmitButton()
    }
  }
}