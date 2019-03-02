import oolong.Dependencies

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
    implementation(project(":oolong-android"))
    implementation(project(":samples:time:core"))
    implementation(Dependencies.Kotlin.StdLib)
    implementation(Dependencies.Kotlin.Coroutines.Android)
    implementation(Dependencies.Android.X.AppCompat)
}