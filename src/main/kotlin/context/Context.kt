package context

import config.holders.CrmConfigurationHolder
import config.holders.WebDriverConfigurationHolder

object Context {
  const val crmConfigurationPath: String = "crm-configuration.yaml"
  const val webDriverConfigurationPath: String = "webdriver-configuration.yaml"

  val login = CrmConfigurationHolder.getCrmConfiguration().user.login
  val password = CrmConfigurationHolder.getCrmConfiguration().user.password
  private val host = CrmConfigurationHolder.getCrmConfiguration().crm.host
  private val endpoint = CrmConfigurationHolder.getCrmConfiguration().crm.endpoint
  val crmLoginPageUrl = host + endpoint
  const val captcha = "11111"

  val timeoutAmount = WebDriverConfigurationHolder.getWebDriverConfiguration().timeout
  val browserWidth = WebDriverConfigurationHolder.getWebDriverConfiguration().browserWidth
  val browserHeight = WebDriverConfigurationHolder.getWebDriverConfiguration().browserHeight

}
