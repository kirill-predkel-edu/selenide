package driver.model

internal data class WebDriverConfiguration(
  val timeout: Long,
  val browserScreenSize: String,
  val webDriverType: WebDriverType,
  val browserType: BrowserType
)

internal enum class BrowserType(val browserName: String) {
  CHROME("chrome"),
  FIREFOX("firefox")
}

internal enum class WebDriverType() {
  LOCAL,
  REMOTE
}
