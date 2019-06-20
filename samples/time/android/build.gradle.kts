plugins {
    id("com.android.application")
    kotlin("android")
}

repositories {
    google()
    mavenCentral()
    jcenter()
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "sample.time"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {
    implementation(project(":samples:time:core"))
    implementation(deps.Kotlin.StdLib.Jvm)
    implementation(deps.Kotlin.Coroutines.Android)
    implementation(deps.Android.X.AppCompat.Core)
}
