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
        applicationId = "oolong.todo"
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
    implementation(project(":samples:todo:core"))
    implementation(deps.Kotlin.StdLib)
    implementation(deps.Kotlin.Coroutines.Core)
    implementation(deps.Kotlin.Coroutines.Android)
    implementation(deps.Android.X.AppCompat)
}
