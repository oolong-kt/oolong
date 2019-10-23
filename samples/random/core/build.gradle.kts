version = "1.0.0"

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}

kotlin {
    js()
    jvm()
    iosX64("ios")
    linuxX64("linux")
    macosX64("macOS")
    mingwX64("windows")

    cocoapods {
        summary = "Random Sample"
        homepage = "https://github.com/oolong-kt/oolong/tree/master/samples/random"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":oolong"))
                implementation(project(":samples:util:core"))
                implementation(deps.Kotlin.StdLib.Common)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(deps.Kotlin.StdLib.Js)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(deps.Kotlin.StdLib.Jvm)
            }
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations {
    create("compileClasspath")
}
