val GROUP: String by project
val VERSION_NAME: String by project

group = GROUP
version = VERSION_NAME

plugins {
    kotlin("multiplatform")
}

repositories {
    jcenter()
}

kotlin {
    jvm()

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
    }

    targets {
        val coroutinesNativeTargets = listOf(
            "iosarm32",
            "iosarm64",
            "iosx64",
            "linuxx64",
            "macosx64",
            "mingwx64",
            "tvosarm64",
            "tvosx64",
            "watchosarm32",
            "watchosarm64",
            "watchosx86"
        )

        presets
            .filter { it.name.toLowerCase() in coroutinesNativeTargets }
            .forEach { preset ->
                targetFromPreset(preset, preset.name) {
                    compilations["main"].source(sourceSets["nativeMain"])
                    compilations["test"].source(sourceSets["nativeTest"])
                }
            }
    }
}

apply("$rootDir/gradle/gradle-mvn-mpp-push.gradle")
