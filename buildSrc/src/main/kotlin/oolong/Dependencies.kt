package oolong

import oolong.dsl.Dependency
import oolong.dsl.Dependency.Group

object Dependencies {

    object Dokka : Group("org.jetbrains.dokka", "0.9.17") {
        object Gradle : Group(Dokka) {
            object Plugin : Group(Gradle) {
                override val DEFAULT = Dependency(this, "dokka-gradle-plugin")
            }
        }
    }

    object Kotlin : Group("org.jetbrains.kotlin", "1.3.21") {
        private const val BASE = "kotlin"
        val Reflect = Dependency(this, "$BASE-reflect")

        object Coroutines : Group("org.jetbrains.kotlinx", "1.1.1") {
            private const val BASE = "kotlinx-coroutines"
            val Android = Dependency(this, "$BASE-android")
            val JavaFX = Dependency(this, "$BASE-javafx")
            val Swing = Dependency(this, "$BASE-swing")

            object Core : Group(Coroutines) {
                private const val BASE = "kotlinx-coroutines-core"
                val Common = Dependency(this, "$BASE-common")
                override val DEFAULT = Dependency(this, BASE)
            }
        }

        object Gradle : Group(Kotlin) {
            object Plugin : Group(Gradle) {
                override val DEFAULT = Dependency(this, "kotlin-gradle-plugin")
            }
        }

        object StdLib : Group(Kotlin) {
            private const val BASE = "kotlin-stdlib"
            val Common = Dependency(this, "$BASE-common")
            val JDK8 = Dependency(this, "$BASE-jdk8")
            override val DEFAULT = Dependency(this, BASE)
        }

        object Test : Group(Kotlin) {
            private const val BASE = "kotlin-test"
            val Common = Dependency(this, "$BASE-common")
            override val DEFAULT = Dependency(this, BASE)
        }
    }

    object Spek : Group("org.spekframework.spek2", "2.0.0") {
        object Dsl : Group(Spek) {
            private const val BASE = "spek-dsl"
            val Jvm = Dependency(this, "$BASE-jvm")
            val Metadata = Dependency(this, "$BASE-metadata")
        }

        object Runner : Group(Spek) {
            private const val BASE = "spek-runner"
            val JUnit5 = Dependency(this, "$BASE-junit5")
        }
    }

    object TornadoFX : Group("no.tornado", "1.7.18") {
        override val DEFAULT = Dependency(this, "tornadofx")
    }

    object Truth : Group("com.google.truth", "0.42") {
        override val DEFAULT = Dependency(this, "truth")
    }

}