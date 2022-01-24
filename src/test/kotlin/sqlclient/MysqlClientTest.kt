package sqlclient

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import sql.CustomSqlClient
import sql.UserAccountsQueries.userAccountByDeletedSelectQuery
import sql.UserAccountsQueries.userAccountByIdSelectQuery

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class MysqlClientTest {
  private lateinit var mySqlClient: CustomSqlClient
  private val userAccountIdParam = mapOf("id" to 38276)
  private val expectedUserAccountId: Long? = userAccountIdParam["id"]?.toLong()
  private val userAccountDeletedUsersParam = mapOf("deleted" to "false")

  @BeforeAll
  fun setupMySqlClient() {
    mySqlClient = CustomSqlClient()
  }
  
  @AfterAll
  fun closeMysqlConnection() {
    mySqlClient.closeSession()
  }

  @Test
  fun `User account ID from the query equals to ID from query result`() {
    val userAccountData: Map<String, Any?> =
      mySqlClient.selectFirstRow(userAccountByIdSelectQuery, userAccountIdParam)
    val actualUserAccountId: Any? = userAccountData["id"]
    assertEquals(expectedUserAccountId, actualUserAccountId, "ID's aren't equal")
  }

  @Test
  fun `Query result can contain multiple rows`() {
    val userAccountData: List<Map<String, Any?>> =
      mySqlClient.selectAllRows(userAccountByDeletedSelectQuery, userAccountDeletedUsersParam)
    val userAccountDataSize = userAccountData.size
    assertTrue(userAccountDataSize > 1, "There are less than 1 row in query result")
  }
}