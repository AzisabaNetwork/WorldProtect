plugins {
    java
}

group = "net.azisaba"
version = "2.1.0"

java.toolchain.languageVersion.set(JavaLanguageVersion.of(8))

repositories {
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://hub.spigotmc.org/nexus/content/repositories/public/") }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.15.2-R0.1-SNAPSHOT")
}

tasks {
    processResources {
        // replace @version@
        filesMatching(listOf("plugin.yml")) {
            filter(org.apache.tools.ant.filters.ReplaceTokens::class, mapOf(
                "tokens" to mapOf(
                    "version" to project.version.toString()
                )
            ))
        }
    }
}
