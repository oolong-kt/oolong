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
                implementation(deps.kotlin.stdlib.common)
                api(deps.kotlin.coroutines.core.common)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(deps.kotlin.test.common)
                implementation(deps.kotlin.test.annotations_common)
            }
        }

        val jvmMain by getting {
            dependencies {
                api(deps.kotlin.coroutines.core.jvm)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(deps.kotlin.test.jvm)
                implementation(deps.kotlin.test.junit5)
            }
        }

        val nativeMain by creating {
            dependencies {
                api(deps.kotlin.coroutines.core.native)
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
