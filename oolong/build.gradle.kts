import oolong.Dependencies

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
    jvm()
    iosX64("ios")
    linuxX64("linux")
    macosX64("macOS")
    mingwX64("windows")

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.Kotlin.StdLib.Common)
                api(Dependencies.Kotlin.Coroutines.Core.Common)
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
                api(Dependencies.Kotlin.Coroutines.Core.JS)
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(Dependencies.Kotlin.Test.JS)
            }
        }

        val jvmMain by getting {
            dependencies {
                api(Dependencies.Kotlin.Coroutines.Core)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(Dependencies.Kotlin.Test)
                implementation(Dependencies.Kotlin.Test.JUnit5)
            }
        }

        val iosMain by getting {
            dependencies {
                api(Dependencies.Kotlin.Coroutines.Core.Native)
            }
        }

        val linuxMain by getting {
            dependencies {
                api(Dependencies.Kotlin.Coroutines.Core.Native)
            }
        }

        val macOSMain by getting {
            dependencies {
                api(Dependencies.Kotlin.Coroutines.Core.Native)
            }
        }

        val windowsMain by getting {
            dependencies {
                api(Dependencies.Kotlin.Coroutines.Core.Native)
            }
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations {
    create("compileClasspath")
}

apply("$rootDir/gradle/gradle-mvn-mpp-push.gradle")
