package config.provider

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.nio.file.FileSystems
import java.nio.file.Files

object YamlToObject {

  inline fun <reified T : Any> readYaml(filePath: String): T {
    return Files.newBufferedReader(FileSystems.getDefault().getPath(filePath)).use {
      ObjectMapper(YAMLFactory()).registerModule(KotlinModule()).readValue(it, T::class.java)
    }
  }
}