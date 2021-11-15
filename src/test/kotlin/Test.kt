import com.codeborne.selenide.Selenide.open
import context.Context.captcha
import context.Context.crmLoginPageUrl
import context.Context.login
import context.Context.password
import org.junit.jupiter.api.Test
import ui.crm.CrmLoginPage

internal class Test : BaseTest() {

  @Test
  fun crmLogin() {
    val crmLoginPage = CrmLoginPage()
    open(crmLoginPageUrl)
    crmLoginPage.apply {
      inputEmail(login)
      inputPassword(password)
      inputCaptcha(captcha)
    }
    crmLoginPage.clickSubmitButton()
  }
}