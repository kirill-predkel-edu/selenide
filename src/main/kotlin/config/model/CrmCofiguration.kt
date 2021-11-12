package config.model

data class CrmConfiguration(
  val user: UserConfiguration,
  val crm: CrmUrlConfiguration
)

data class CrmUrlConfiguration(
  val host: String?,
  val endpoint: String?
)

data class UserConfiguration(
  val login: String?,
  val password: String?
)