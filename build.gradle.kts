buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(oolong.Dependencies.Android.Gradle.Plugin)
        classpath(oolong.Dependencies.Kotlin.Gradle.Plugin)
        classpath(oolong.Dependencies.Dokka.Gradle.Plugin)
    }
}
