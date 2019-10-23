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
    macosX64("macos")
    mingwX64("windows")

    cocoapods {
        summary = "Counter Sample"
        homepage = "https://github.com/oolong-kt/oolong/tree/master/samples/counter"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":oolong"))
                implementation(project(":samples:util:core"))
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
                implementation(deps.Kotlin.StdLib.Js)
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test.Js)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(deps.Kotlin.StdLib.Jvm)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test.Jvm)
                implementation(deps.Kotlin.Test.JUnit5)
            }
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations {
    create("compileClasspath")
}
