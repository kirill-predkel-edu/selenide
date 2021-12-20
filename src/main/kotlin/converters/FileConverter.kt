package converters

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.nio.file.FileSystems
import java.nio.file.Files

object FileConverter {
  fun jsonToString(jsonFileName: String?): String? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(jsonFileName)?.readBytes()
      ?.toString(Charsets.UTF_8)
  }

  fun <T> yamlToObject(filePath: String, objectClass: Class<T>): T =
    Files.newBufferedReader(FileSystems.getDefault().getPath(filePath)).use {
      ObjectMapper(YAMLFactory()).registerModule(KotlinModule()).readValue(it, objectClass)
    }
}