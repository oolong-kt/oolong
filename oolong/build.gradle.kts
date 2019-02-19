import oolong.Dependencies

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
                implementation(Dependencies.Kotlin.StdLib.Common)
                implementation(Dependencies.Kotlin.Coroutines.Core.Common)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(Dependencies.Kotlin.Test.Common)
                implementation(Dependencies.Spek.Dsl.Metadata)
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation(Dependencies.Kotlin.StdLib.JDK8)
                implementation(Dependencies.Kotlin.Coroutines.Core)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(Dependencies.Kotlin.Test)
                implementation(Dependencies.Spek.Dsl.Jvm)

                runtimeOnly(Dependencies.Kotlin.Reflect)
                runtimeOnly(Dependencies.Spek.Runner.JUnit5)
            }
        }

    }
}

tasks {
    val jvmTest by getting(Test::class) {
        useJUnitPlatform {
            includeEngines("spek2")
        }
    }
}