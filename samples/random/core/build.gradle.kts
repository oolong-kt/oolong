plugins {
    kotlin("multiplatform")
}

repositories {
    jcenter()
}

kotlin {
    js()
    jvm()
    iosX64("ios")
    linuxX64("linux")
    macosX64("macOS")
    mingwX64("windows")

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":oolong"))
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
