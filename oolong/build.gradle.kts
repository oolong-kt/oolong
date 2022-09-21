import com.vanniktech.maven.publish.JavadocJar.Dokka
import com.vanniktech.maven.publish.KotlinMultiplatform
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinNativeTargetPreset

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
    alias(libs.plugins.spotless)
}

repositories { mavenCentral() }

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotlin.coroutines.core)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.coroutines.test)
                implementation(libs.kotlin.test.common)
                implementation(libs.kotlin.test.commonAnnotations)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(libs.kotlin.test.junit)
            }
        }

        val nativeMain by creating
    }

    targets {
        // Print supported targets with:
        // scripts/fetch_native_targets org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4
        val supportedTargets =
            setOf(
                "ios_arm32",
                "ios_arm64",
                "ios_simulator_arm64",
                "ios_x64",
                "linux_x64",
                "macos_arm64",
                "macos_x64",
                "mingw_x64",
                "tvos_arm64",
                "tvos_simulator_arm64",
                "tvos_x64",
                "watchos_arm32",
                "watchos_arm64",
                "watchos_simulator_arm64",
                "watchos_x64",
                "watchos_x86",
            )

        presets
            .filterIsInstance<AbstractKotlinNativeTargetPreset<*>>()
            .filter { it.konanTarget.name in supportedTargets }
            .forEach { preset ->
                try {
                    targetFromPreset(preset, preset.name) {
                        compilations["main"].source(sourceSets["nativeMain"])
                    }
                } catch (e: Exception) {
                    println("Unsupported target: ${preset.name}")
                }
            }
    }
}

spotless {
    kotlin {
        target("**/*.kt")
        ktfmt("0.40").kotlinlangStyle()
    }
}

configure<MavenPublishBaseExtension> {
    configure(KotlinMultiplatform(javadocJar = Dokka("dokkaGfm")))
}
