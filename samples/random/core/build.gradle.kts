version = "1.0.0"

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

repositories {
    jcenter()
}

kotlin {
    js()
    jvm()
    iosX64("ios") {
        binaries {
            getFramework("debug").apply {
                export(project(":oolong"))
                export(deps.Kotlin.Coroutines.Core)
                transitiveExport = true
            }
        }
    }
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
                api(deps.Kotlin.Coroutines.Core)
                implementation(deps.Kotlin.StdLib.Common)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(deps.Kotlin.StdLib.JS)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(deps.Kotlin.StdLib.JDK8)
            }
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations {
    create("compileClasspath")
}
