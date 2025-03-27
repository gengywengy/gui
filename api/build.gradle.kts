import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.vanniktech.maven.publish") version "0.31.0"
}

group = rootProject.group
version = rootProject.version

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation(project(":spigot:common"))
}

kotlin {
    jvmToolchain(21)
}

mavenPublishing {
    coordinates(
        groupId = "dev.gengy",
        artifactId = "gui",
        version = version as String
    )
    pom {
        name.set("GUI")
        description.set("Spigot GUI library")
        inceptionYear.set("2025")
        url.set("https://github.com/gengywengy/gui/")

        licenses {
            license {
                name.set("GPL v3.0")
                url.set("https://www.gnu.org/licenses/gpl-3.0.en.html#license-text")
                distribution.set("https://www.gnu.org/licenses/gpl-3.0.en.html#license-text")
            }
        }

        developers {
            developer {
                id.set("gengyweny")
                name.set("Gengar")
                url.set("https://github.com/gengywengy")
            }
        }

        scm {
            url.set("https://github.com/gengywengy/gui/")
            connection.set("scm:git:git://github.com/gengywengy/gui.git")
            developerConnection.set("scm:git:ssh://git@github.com/gengywengy/gui.git")
        }
    }

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)
    signAllPublications()
}