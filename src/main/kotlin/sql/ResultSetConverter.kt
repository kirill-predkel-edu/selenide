package sql

import java.sql.ResultSet

object ResultSetConverter {

  val singleRowToMap: (ResultSet) -> Map<String, Any?> = { resultSet ->
    val singleRow = mutableMapOf<String, Any?>()
    val columnCount = resultSet.metaData.columnCount
    resultSet.next()
    for (columnNumber in 1..columnCount) {
      val columnLabel = resultSet.metaData.getColumnLabel(columnNumber)
      singleRow[columnLabel] = resultSet.getObject(columnLabel)
    }
    singleRow
  }

  val multipleRowsToList: (ResultSet) -> MutableList<Map<String, Any?>> = { resultSet ->
    val singleRow = mutableMapOf<String, Any?>()
    val multipleRows = mutableListOf<Map<String, Any?>>()
    val columnCount = resultSet.metaData.columnCount
    while (resultSet.next()) {
      for (columnNumber in 1..columnCount) {
        val columnLabel = resultSet.metaData.getColumnLabel(columnNumber)
        singleRow[columnLabel] = resultSet.getObject(columnLabel)
      }
      multipleRows.add(singleRow)
    }
    multipleRows
  }
}