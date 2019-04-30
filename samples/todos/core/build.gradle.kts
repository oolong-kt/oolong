plugins {
    kotlin("multiplatform")
}

repositories {
    jcenter()
}

kotlin {
    jvm()
    iosX64("ios")

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":oolong"))
                implementation(deps.Kotlin.StdLib.Common)
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
