package driver.model

data class WebDriverConfiguration(
  val timeout: Long,
  val browserScreenSize: String,
  val webDriverType: String,
  val browserType: String
)
