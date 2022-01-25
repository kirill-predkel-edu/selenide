package sql

object UserAccountsQueries {
  val userAccountByIdSelectQuery: String = """
  select *
  from user_account
  where id = :id
  """.trimIndent()

  val userAccountByDeletedSelectQuery: String = """
  select *
  from user_account
  where deleted = :deleted
  """.trimIndent()

}