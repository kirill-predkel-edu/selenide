package config.model

internal data class ApplicationConfiguration(
  val host: String,
  val basicAuth: BasicAuth,
  val crm: CrmConfiguration,
  val registration: RegistrationConfiguration
)

internal data class CrmConfiguration(
  val loginEndpoint: String,
  val crmUser: CrmUserConfiguration
)

internal data class CrmUserConfiguration(
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