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
    mavenCentral()
    jcenter()
}

kotlin {
    jvm()
    js {
        compilations.all {
            kotlinOptions {
                main = "noCall"
                moduleKind = "umd"
                noStdlib = false
                sourceMap = true
            }
        }
    }
    iosArm32 {
        binaries {
            framework()
        }
    }
    iosArm64 {
        binaries {
            framework()
        }
    }
    iosX64 {
        binaries {
            framework()
        }
    }
    linuxX64()
    macosX64()
    mingwX64()

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
                api(deps.Kotlin.Coroutines.Core.Js)
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test.Js)
            }
        }

        val jvmMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.Jvm)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test.Jvm)
                implementation(deps.Kotlin.Test.JUnit5)
            }
        }

        val nativeMain by creating {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.Native)
            }
        }

        val nativeTest by creating {
        }

        val iosArm32Main by getting {
            dependsOn(nativeMain)
        }

        val iosArm32Test by getting {
            dependsOn(nativeTest)
        }

        val iosArm64Main by getting {
            dependsOn(nativeMain)
        }

        val iosArm64Test by getting {
            dependsOn(nativeTest)
        }

        val iosX64Main by getting {
            dependsOn(nativeMain)
        }

        val iosX64Test by getting {
            dependsOn(nativeTest)
        }

        val linuxX64Main by getting {
            dependsOn(nativeMain)
        }

        val linuxX64Test by getting {
            dependsOn(nativeTest)
        }

        val macosX64Main by getting {
            dependsOn(nativeMain)
        }

        val macosX64Test by getting {
            dependsOn(nativeTest)
        }

        val mingwX64Main by getting {
            dependsOn(nativeMain)
        }

        val mingwX64Test by getting {
            dependsOn(nativeTest)
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations.create("compileClasspath")

apply("$rootDir/gradle/gradle-mvn-mpp-push.gradle")
