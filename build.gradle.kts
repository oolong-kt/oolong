buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(deps.kotlin.gradle.plugin)
        classpath(deps.dokka.gradle.plugin)
    }
}

