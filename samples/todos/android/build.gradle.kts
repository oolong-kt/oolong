import deps.dsl.compileOnly
import deps.dsl.implementation
import deps.dsl.kapt

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

repositories {
    google()
    jcenter()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "oolong.todos"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_1_8
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {
    kapt(
        deps.Facebook.Litho.Processor,
        deps.Facebook.Litho.Sections.Processor
    )
    compileOnly(
        deps.Facebook.Litho.Sections.Annotations
    )
    implementation(
        project(":samples:todos:core"),
        deps.Android.X.AppCompat,
        deps.Facebook.Flipper,
        deps.Facebook.Litho,
        deps.Facebook.Litho.Widget,
        deps.Facebook.Litho.Sections,
        deps.Facebook.Litho.Sections.Widget,
        deps.Facebook.SoLoader,
        deps.Kotlin.Coroutines.Core,
        deps.Kotlin.Coroutines.Android,
        deps.Kotlin.StdLib,
        deps.Max.Matcher,
        deps.Max.Router,
        deps.Max.Navigator
    )
}
