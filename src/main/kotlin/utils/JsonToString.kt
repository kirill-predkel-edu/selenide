package utils

internal object JsonToString {
  fun readJson(jsonFileName: String): String? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(jsonFileName)?.readBytes()?.toString(Charsets.UTF_8)
  }
}