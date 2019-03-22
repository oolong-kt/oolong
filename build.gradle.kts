buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(deps.Android.Gradle.Plugin)
        classpath(deps.Kotlin.Gradle.Plugin)
        classpath(deps.Dokka.Gradle.Plugin)
    }
}
