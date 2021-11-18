package config.model

internal data class ApplicationConfiguration(
  val user: UserConfiguration,
  val crm: CrmUrlConfiguration
)

internal data class CrmUrlConfiguration(
  val host: String,
  val endpoint: String
)

internal data class UserConfiguration(
  val login: String,
  val password: String,
  val captcha: String
)