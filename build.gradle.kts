plugins {
    java
    alias(libs.plugins.intellijPlatform)
}

group = "io.github.holgerbrandl"
version = "1.8.0-dev"

repositories {
    mavenCentral()

    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        local("${System.getProperty("user.home")}/.local/opt/WebStorm")
        bundledPlugin("org.jetbrains.plugins.terminal")
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "263"
        }
    }
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}