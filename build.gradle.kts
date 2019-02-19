buildscript {
    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath(oolong.Dependencies.Kotlin.Gradle.Plugin)
        classpath(oolong.Dependencies.Dokka.Gradle.Plugin)
    }
}
