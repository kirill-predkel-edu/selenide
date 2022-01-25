package sql

import java.sql.ResultSet

object ResultSetConverter {

  val singleRowToMap: (ResultSet) -> Map<String, Any?> = { resultSet ->
    val singleRow = mutableMapOf<String, Any?>()
    val metaData = resultSet.metaData
    val columnCount = metaData.columnCount
    resultSet.next()
    for (columnNumber in 1..columnCount) {
      val columnLabel = metaData.getColumnLabel(columnNumber)
      singleRow[columnLabel] = resultSet.getObject(columnLabel)
    }
    singleRow
  }

  val multipleRowsToList: (ResultSet) -> MutableList<Map<String, Any?>> = { resultSet ->
    val multipleRows = mutableListOf<Map<String, Any?>>()
    do  {
      val singleRow: Map<String, Any?> = singleRowToMap.invoke(resultSet)
      multipleRows.add(singleRow)
    }
    while (!resultSet.isLast)
    multipleRows
  }
}