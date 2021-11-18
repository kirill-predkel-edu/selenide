package utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.nio.file.FileSystems
import java.nio.file.Files

internal object YamlToObject {

  fun <T> readYaml(filePath: String, objectClass: Class<T>): T =
    Files.newBufferedReader(FileSystems.getDefault().getPath(filePath)).use {
      ObjectMapper(YAMLFactory()).registerModule(KotlinModule()).readValue(it, objectClass)
    }
}