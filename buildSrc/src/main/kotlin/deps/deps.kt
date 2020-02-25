package deps

object Dokka : Group("org.jetbrains.dokka", "0.10.1") {
    object Gradle {
        val Plugin = artifact("dokka-gradle-plugin")
    }
}

object Kotlin : Group("org.jetbrains.kotlin", "1.3.61") {
    object Coroutines : Group("org.jetbrains.kotlinx", "1.3.3") {
        object Core {
            val Common = artifact("kotlinx-coroutines-core-common")
            val Jvm = artifact("kotlinx-coroutines-core")
            val Native = artifact("kotlinx-coroutines-core-native")
        }
    }

    object Gradle {
        val Plugin = artifact("kotlin-gradle-plugin")
    }

    object StdLib {
        val Common = artifact("kotlin-stdlib-common")
    }

    object Test {
        val AnnotationsCommon = artifact("kotlin-test-annotations-common")
        val Common = artifact("kotlin-test-common")
        val JUnit5 = artifact("kotlin-test-junit5")
        val Jvm = artifact("kotlin-test")
    }
}
