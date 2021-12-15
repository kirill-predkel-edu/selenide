import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import wiremock.WiremockServer

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class BaseWiremockTest {
  private val wiremock = WiremockServer().getWiremock()

  @BeforeAll
  fun setupWireMock() {
    wiremock.start()
    WiremockServer().configureWiremock()
  }

  @AfterAll
  fun teardownWiremock() {
    wiremock.stop()
  }
}