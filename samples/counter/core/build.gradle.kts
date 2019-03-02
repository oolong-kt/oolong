import oolong.Dependencies

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
                implementation(project(":oolong"))
                implementation(Dependencies.Kotlin.StdLib.Common)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(Dependencies.Kotlin.Test.Common)
                implementation(Dependencies.Kotlin.Test.AnnotationsCommon)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(Dependencies.Kotlin.StdLib.JS)
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(Dependencies.Kotlin.Test.JS)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(Dependencies.Kotlin.StdLib.JDK8)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(Dependencies.Kotlin.Test)
                implementation(Dependencies.Kotlin.Test.JUnit5)
            }
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations {
    create("compileClasspath")
}
