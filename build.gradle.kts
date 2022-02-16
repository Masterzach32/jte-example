plugins {
    kotlin("jvm") version "1.6.10"
    id("gg.jte.gradle") version "1.12.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val jteVersion = "1.12.1"
    implementation("gg.jte:jte:$jteVersion")
    runtimeOnly("gg.jte:jte-kotlin:$jteVersion")
}

jte {
    generate()
    sourceDirectory.set(file("src/main/kte").toPath())
}
