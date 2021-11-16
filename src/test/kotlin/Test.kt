import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.Test
import ui.crm.CrmLoginPage

internal class Test : BaseTest() {

  @Test
  fun crmLogin() {
    val crmLoginPage = CrmLoginPage()
    open(config.crm.host + config.crm.endpoint)
    crmLoginPage.apply {
      inputEmail(config.user.login)
      inputPassword(config.user.password)
      inputCaptcha(config.user.captcha)
    }
    crmLoginPage.clickSubmitButton()
  }
}