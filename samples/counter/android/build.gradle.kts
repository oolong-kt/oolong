plugins {
    id("com.android.application")
    kotlin("android")
}

repositories {
    google()
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "sample.counter"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {
    implementation(project(":samples:counter:core"))
    implementation(deps.Android.X.AppCompat)
    implementation(deps.Android.X.UI.Framework)
    implementation(deps.Android.X.UI.Tooling)
    implementation(deps.Android.X.UI.Layout)
    implementation(deps.Android.X.UI.Material)
    implementation(deps.Android.X.Compose.Runtime)
    implementation(deps.Kotlin.StdLib.Jvm)
    implementation(deps.Kotlin.Coroutines.Core.Jvm)
    implementation(deps.Kotlin.Coroutines.Android)
}
