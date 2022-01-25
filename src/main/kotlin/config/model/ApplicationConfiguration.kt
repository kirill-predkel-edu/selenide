package config.model

internal data class ApplicationConfiguration(
  var host: String,
  val wiremockConfiguration: WiremockConfiguration,
  val basicAuth: BasicAuth,
  val crm: CrmConfiguration,
  val registration: RegistrationConfiguration,
  val sqlConfiguration: SqlConfiguration
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

internal data class WiremockConfiguration(
  val wiremockPort: Int,
  val wiremockHost: String,
  val wiremockProtocol: String
) {
  fun getWiremockBaseURL(): String {
    return "$wiremockProtocol$wiremockHost:$wiremockPort"
  }
}

internal data class SqlConfiguration(
  val dbUrl: String,
  val user: String,
  val password: String
)
