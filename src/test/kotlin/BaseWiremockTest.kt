import com.github.tomakehurst.wiremock.WireMockServer
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal abstract class BaseWiremockTest {
  //val wiremock = CustomWiremockServer()

 @BeforeAll
  fun setupWireMock() {
    //wiremock.configureWiremock()
  }

  @AfterAll
  fun teardownWiremock() {

  }
}