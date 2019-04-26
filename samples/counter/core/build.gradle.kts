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
    macosX64("macos") {
        binaries {
            getFramework("debug").apply {
                export(project(":oolong"))
                export(deps.Kotlin.Coroutines.Core)
                transitiveExport = true
            }
        }
    }
    mingwX64("windows")

    cocoapods {
        summary = "Counter Sample"
        homepage = "https://github.com/oolong-kt/oolong/tree/master/samples/counter"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":oolong"))
                api(deps.Kotlin.Coroutines.Core)
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
