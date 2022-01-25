package sql

import com.vladsch.kotlin.jdbc.Session

interface SqlClient {
  fun getSession(): Session

  fun selectFirstRow(
    statement: String,
    inputParams: Map<String, Any?>
    ): Map<String, Any?>?

  fun selectAllRows(
    statement: String,
    inputParams: Map<String, Any?>
    ): List<Map<String, Any?>>

  fun closeSession()
}