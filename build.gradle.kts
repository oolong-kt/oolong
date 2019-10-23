buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }
    dependencies {
        classpath(deps.Android.Gradle.Plugin)
        classpath(deps.Kotlin.Gradle.Plugin)
        classpath(deps.Dokka.Gradle.Plugin)
    }
}

