package sql

import com.vladsch.kotlin.jdbc.Session
import com.vladsch.kotlin.jdbc.session
import com.vladsch.kotlin.jdbc.sqlQuery
import config.holder.ApplicationConfigurationHolder
import sql.ResultSetConverter.multipleRowsToList
import sql.ResultSetConverter.singleRowToMap

internal class CustomSqlClient : SqlClient {
  private val sqlConfig = ApplicationConfigurationHolder.getApplicationConfiguration()!!.sqlConfiguration
  private var session: Session? = null

  override fun getSession(): Session {
    if (session == null) {
      session = session(sqlConfig.dbUrl, sqlConfig.user, sqlConfig.password)
    }
    return session as Session
  }

  override fun selectFirstRow(
    statement: String,
    inputParams: Map<String, Any?>
    ): Map<String, Any?> {
    val query = sqlQuery(statement, inputParams)
    println("test")
    return getSession().query(query, singleRowToMap)
  }

  override fun selectAllRows(
    statement: String,
    inputParams: Map<String, Any?>
    ): List<Map<String, Any?>> {
    val query = sqlQuery(statement, inputParams)
    return getSession().query(query, multipleRowsToList)
  }

  override fun closeSession() {
    if (session != null) {
      getSession().close()
      session = null
    }
  }
}