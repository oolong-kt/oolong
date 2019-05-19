buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath(deps.Android.Gradle.Plugin)
        classpath(deps.Kotlin.Gradle.Plugin)
        classpath(deps.Node.Gradle.Plugin)
        classpath(deps.Dokka.Gradle.Plugin)
    }
}
