import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinNativeTargetPreset

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
        val unsupportedTargets = setOf(
            "android_arm32",
            "android_arm64",
            "android_x64",
            "android_x86",
            "linux_arm32_hfp",
            "linux_arm64",
            "linux_mips32",
            "linux_mipsel32",
            "mingw_x86",
            "wasm32"
        )

        presets
            .filterIsInstance<AbstractKotlinNativeTargetPreset<*>>()
            .filter { it.konanTarget.name !in unsupportedTargets }
            .forEach { preset ->
                try {
                    targetFromPreset(preset, preset.name) {
                        compilations["main"].source(sourceSets["nativeMain"])
                        compilations["test"].source(sourceSets["nativeTest"])
                    }
                } catch (e: Exception) {
                    println("Unsupported target: ${preset.name}")
                }
            }
    }
}

apply("$rootDir/gradle/gradle-mvn-mpp-push.gradle")
