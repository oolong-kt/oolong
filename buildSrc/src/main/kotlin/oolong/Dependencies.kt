package oolong

import oolong.Dependency.Artifact
import oolong.Dependency.Group

object Dependencies {

    object Dokka : Group("org.jetbrains.dokka", "0.9.17") {
        object Gradle : Group(Dokka) {
            object Plugin : Group(Gradle) {
                override val DEFAULT = Artifact("dokka-gradle-plugin")
            }
        }
    }

    object Kotlin : Group("org.jetbrains.kotlin", "1.3.21") {

        object Coroutines : Group("org.jetbrains.kotlinx", "1.1.1") {
            private val BASE = "kotlinx-coroutines"
            val Android = Dependency(this, "$BASE-android")
            val JavaFX = Dependency(this, "$BASE-javafx")
            val Swing = Dependency(this, "$BASE-swing")
            override val DEFAULT = Artifact("$BASE-core")
        }

        object Gradle : Group(Kotlin) {
            object Plugin : Group(Gradle) {
                override val DEFAULT = Artifact("kotlin-gradle-plugin")
            }
        }

        object StdLib : Group(Kotlin) {
            override val DEFAULT = Artifact("kotlin-stdlib")
        }

        object Test : Group(Kotlin) {
            override val DEFAULT = Artifact("kotlin-test")
        }
    }

    object KotlinTest : Group("io.kotlintest", "3.2.1") {
        object Runner : Group(KotlinTest) {
            override val DEFAULT = Artifact("kotlintest-runner-junit5")
        }
    }

    object TornadoFX : Group("no.tornado", "1.7.18") {
        override val DEFAULT = Artifact("tornadofx")
    }

    object Truth : Group("com.google.truth", "0.42") {
        override val DEFAULT = Artifact("truth")
    }

}