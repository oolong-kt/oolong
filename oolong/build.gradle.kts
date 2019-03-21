val GROUP: String by project
val VERSION_NAME: String by project

group = GROUP
version = VERSION_NAME

plugins {
    kotlin("multiplatform")
    `maven-publish`
    signing
}

repositories {
    jcenter()
}

kotlin {
    js()
    js {
        compilations["main"].kotlinOptions {
            moduleKind = "umd"
            sourceMap = true
        }
    }
    jvm()
    iosX64("ios")
    linuxX64("linux")
    macosX64("macOS")
    mingwX64("windows")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(deps.Kotlin.StdLib.Common)
                api(deps.Kotlin.Coroutines.Core.Common)
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
                api(deps.Kotlin.Coroutines.Core.JS)
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test.JS)
            }
        }

        val jvmMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test)
                implementation(deps.Kotlin.Test.JUnit5)
            }
        }

        val iosMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.Native)
            }
        }

        val linuxMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.Native)
            }
        }

        val macOSMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.Native)
            }
        }

        val windowsMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.Native)
            }
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations {
    create("compileClasspath")
}

apply("$rootDir/gradle/gradle-mvn-mpp-push.gradle")
