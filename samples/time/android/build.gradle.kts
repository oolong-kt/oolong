plugins {
    id("com.android.application")
    kotlin("android")
}

repositories {
    google()
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
}

dependencies {
    implementation(project(":samples:time:core"))
    implementation(deps.Kotlin.StdLib)
    implementation(deps.Kotlin.Coroutines.Android)
    implementation(deps.Android.X.AppCompat)
}
