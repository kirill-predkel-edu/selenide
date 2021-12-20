package config.model

internal data class ApplicationConfiguration(
  var host: String,
  val wiremockPort: Int,
  val wiremockHost: String,
  val wiremockProtocol: String,
  val basicAuth: BasicAuth,
  val crm: CrmConfiguration,
  val registration: RegistrationConfiguration
)

internal data class CrmConfiguration(
  val loginEndpoint: String,
  val crmUser: CrmUserConfiguration
)

data class CrmUserConfiguration(
  val login: String,
  val password: String,
  val captcha: String
)

internal data class RegistrationConfiguration(
  val registrationEndpoint: String
)

internal data class BasicAuth(
  val login: String,
  val password: String,
)