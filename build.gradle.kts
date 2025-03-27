plugins {
    kotlin("jvm") version "2.1.20"
}

group = "dev.gengy"
version = "0.0.1"

repositories {
    mavenCentral()
}

allprojects {
    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") {
            name = "spigotmc-repo"
        }
        maven("https://oss.sonatype.org/content/groups/public/") {
            name = "sonatype"
        }
        mavenLocal()
    }
}

kotlin {
    jvmToolchain(21)
}