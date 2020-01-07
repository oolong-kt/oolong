buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath(deps.Kotlin.Gradle.Plugin)
        classpath(deps.Dokka.Gradle.Plugin)
    }
}

