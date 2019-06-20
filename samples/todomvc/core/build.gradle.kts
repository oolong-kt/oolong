plugins {
    kotlin("multiplatform")
}

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    js {
        compilations["main"].kotlinOptions {
            moduleKind = "umd"
            sourceMap = true
        }
    }

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

        val jsMain by getting {
            dependencies {
                implementation(deps.Kotlin.StdLib.Js)
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test.Js)
            }
        }
    }
}
