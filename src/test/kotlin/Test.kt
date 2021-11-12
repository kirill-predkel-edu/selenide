import com.codeborne.selenide.Selenide.open
import config.provider.YamlReader
import context.Context.captcha
import context.Context.crmConfigurationPath
import context.Context.crmLoginPageUrl
import context.Context.login
import context.Context.password
import org.junit.jupiter.api.BeforeEach
import ui.crm.CrmLoginPage
import org.junit.jupiter.api.Test

internal class Test : BaseTest() {

  @BeforeEach
  fun readYamlConfiguration() {
    YamlReader().readConfiguration(crmConfigurationPath)
  }

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