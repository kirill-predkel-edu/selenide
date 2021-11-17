package driver.model

data class WebDriverConfiguration(
  val timeout: Long,
  val browserScreenSize: String,
  val webDriverType: WebDriverType,
  val browserType: BrowserType
)

enum class BrowserType(val browserName: String) {
  CHROME("chrome"),
  FIREFOX("firefox")
}

enum class WebDriverType() {
  LOCAL,
  REMOTE
}
