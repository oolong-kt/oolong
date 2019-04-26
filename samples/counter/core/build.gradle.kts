plugins {
    kotlin("multiplatform")
}

repositories {
    jcenter()
}

kotlin {
    js()
    jvm()
    // iosX64("ios")
    // linuxX64("linux")
    // macosX64("macOS")
    // mingwX64("windows")

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":oolong"))
                implementation(deps.Kotlin.StdLib.Common)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test.Common)
                implementation(deps.Kotlin.Test.AnnotationsCommon)
            }
        }

        val jsMain by getting {
            dependencies {
                implementation(deps.Kotlin.StdLib.JS)
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test.JS)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(deps.Kotlin.StdLib.JDK8)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test)
                implementation(deps.Kotlin.Test.JUnit5)
            }
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations {
    create("compileClasspath")
}
