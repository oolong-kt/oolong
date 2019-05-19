version = "1.0.0"

plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    js()
    jvm()
    iosX64("ios")
    linuxX64("linux")
    macosX64("macos")
    mingwX64("windows")

    sourceSets {
        val iosMain by getting {
            dependencies {
                implementation(deps.Kotlin.Coroutines.Core.Native)
            }
        }
        val macosMain by getting {
            dependencies {
                implementation(deps.Kotlin.Coroutines.Core.Native)
            }
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations {
    create("compileClasspath")
}
