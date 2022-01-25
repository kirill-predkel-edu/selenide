plugins {
  kotlin("jvm") version "1.6.10"
  id("io.qameta.allure") version "2.9.6"
}

apply(plugin = "org.jetbrains.kotlin.jvm")
apply(plugin = "io.qameta.allure")

repositories {
  mavenCentral()
}

val jacksonVersion: String by project
val junitJupiterVersion: String by project
val okhttpVersion: String by project
val selenideVersion: String by project
val webDriverManagerVersion: String by project
val retrofitVersion: String by project
val wiremockVersion: String by project
val kotlinReflectVersion: String by project
val logbackVersion: String by project
val kotlinLoggingVersion: String by project
val kotlinJdbcVersion: String by project
val mySqlConnectorVersion: String by project

dependencies {
  implementation(kotlin("stdlib"))
  implementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
  implementation("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
  implementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
  implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
  implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
  implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
  implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
  implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
  implementation("com.codeborne:selenide:$selenideVersion")
  implementation("com.github.tomakehurst:wiremock-jre8:$wiremockVersion")
  implementation("io.github.microutils:kotlin-logging:$kotlinLoggingVersion")
  implementation("ch.qos.logback:logback-classic:$logbackVersion")
  implementation("mysql:mysql-connector-java:$mySqlConnectorVersion")
  implementation("com.vladsch.kotlin-jdbc:kotlin-jdbc:$kotlinJdbcVersion")
  testImplementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinReflectVersion")
  testImplementation("io.github.bonigarcia:webdrivermanager:$webDriverManagerVersion")
}

allure {
  adapter.autoconfigure
  adapter.aspectjWeaver
}

tasks.test {
  useJUnitPlatform()
}