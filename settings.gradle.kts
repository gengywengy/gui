plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "gui"

include("api")
include(
    "spigot:common",
//    "spigot:1_20_R1",
//    "spigot:1_20_R2",
//    "spigot:1_20_R3",
//    "spigot:1_20_R4",
    "spigot:1_21_R1",
    "spigot:1_21_R2"
)

