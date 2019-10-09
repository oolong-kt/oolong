package deps


object Android {
    object Gradle : Group("com.android.tools.build", "3.5.1") {
        val Plugin = artifact("gradle")
    }

    object X {
        object AppCompat : Group("androidx.appcompat", "1.1.0") {
            val Core = artifact("appcompat")
        }
    }
}

object Dokka : Group("org.jetbrains.dokka", "0.9.18") {
    object Gradle {
        val Plugin = artifact("dokka-gradle-plugin")
    }
}

object Kotlin : Group("org.jetbrains.kotlin", "1.3.50") {
    object Coroutines : Group("org.jetbrains.kotlinx", "1.3.2") {
        val Android = artifact("kotlinx-coroutines-android")

        object Core {
            val Common = artifact("kotlinx-coroutines-core-common")
            val Js = artifact("kotlinx-coroutines-core-js")
            val Jvm = artifact("kotlinx-coroutines-core")
            val Native = artifact("kotlinx-coroutines-core-native")
        }
    }

    object Gradle {
        val Plugin = artifact("kotlin-gradle-plugin")
    }

    object StdLib {
        val Common = artifact("kotlin-stdlib-common")
        val Js = artifact("kotlin-stdlib-js")
        val Jvm = artifact("kotlin-stdlib")
    }

    object Test {
        val AnnotationsCommon = artifact("kotlin-test-annotations-common")
        val Common = artifact("kotlin-test-common")
        val JUnit5 = artifact("kotlin-test-junit5")
        val Js = artifact("kotlin-test-js")
        val Jvm = artifact("kotlin-test")
    }
}
