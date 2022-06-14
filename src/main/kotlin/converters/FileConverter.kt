package converters

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.File
import java.nio.file.FileSystems
import java.nio.file.Files

object FileConverter {
  const val RESOURCES_PATH = "src/test/resources/"

  fun jsonToString(jsonFileName: String?): String? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(jsonFileName)?.readBytes()
      ?.toString(Charsets.UTF_8)
  }

  inline fun <reified T : Any> yamlToObject(filePath: String): T {
    return Files.newBufferedReader(FileSystems.getDefault().getPath(filePath)).use {
      ObjectMapper(YAMLFactory()).registerModule(
        KotlinModule.Builder()
          .withReflectionCacheSize(512)
          .configure(KotlinFeature.NullToEmptyCollection, false)
          .configure(KotlinFeature.NullToEmptyMap, false)
          .configure(KotlinFeature.NullIsSameAsDefault, false)
          .configure(KotlinFeature.SingletonSupport, false)
          .configure(KotlinFeature.StrictNullChecks, false)
          .build()
      ).readValue(it)
    }
  }

    inline fun <reified T : Any> jsonToObjectFromResources(filePath: String): T {
      return jacksonObjectMapper().readValue(File("$RESOURCES_PATH$filePath"))
    }
}