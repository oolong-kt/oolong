buildscript {
    repositories {
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
        google()
        jcenter()
    }
    dependencies {
        classpath(deps.Android.Gradle.Plugin)
        classpath(deps.Kotlin.Gradle.Plugin)
        classpath(deps.Node.Gradle.Plugin)
        classpath(deps.Dokka.Gradle.Plugin)
    }
}

allprojects {
    repositories {
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}
