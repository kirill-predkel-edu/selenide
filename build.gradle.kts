plugins {
    kotlin("jvm") version "1.5.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"


apply(plugin = "org.jetbrains.kotlin.jvm")

repositories {
    mavenCentral()
}

val jacksonVersion: String by project
val junitJupiterVersion: String by project
val okhttpVersion: String by project
val selenideVersion: String by project
val webDriverManagerVersion: String by project
val retrofitVersion: String by project

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.junit.jupiter:junit-jupiter-api:$junitJupiterVersion")
    implementation("org.junit.jupiter:junit-jupiter-engine:$junitJupiterVersion")
    implementation("org.junit.jupiter:junit-jupiter-params:$junitJupiterVersion")
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")
    implementation("com.codeborne:selenide:$selenideVersion")
    testImplementation ("org.jetbrains.kotlin:kotlin-reflect:1.1.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:$webDriverManagerVersion")
}

tasks.test {
    useJUnitPlatform()
}