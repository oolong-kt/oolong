package deps


object Android {
    object Gradle : Group("com.android.tools.build", "3.3.0") {
        val Plugin = dependency("gradle")
    }

    object X {
        object AppCompat : Group("androidx.appcompat", "1.0.0") {
            val Core = dependency("appcompat")
        }
    }
}

object Dokka : Group("org.jetbrains.dokka", "0.9.18") {
    object Gradle {
        val Plugin = dependency("dokka-gradle-plugin")
    }
}

object Kotlin : Group("org.jetbrains.kotlin", "1.3.40") {
    object Coroutines : Group("org.jetbrains.kotlinx", "1.2.2") {
        val Android = dependency("kotlinx-coroutines-android")

        object Core {
            val Common = dependency("kotlinx-coroutines-core-common")
            val Js = dependency("kotlinx-coroutines-core-js")
            val Jvm = dependency("kotlinx-coroutines-core")
            val Native = dependency("kotlinx-coroutines-core-native")
        }
    }

    object Gradle {
        val Plugin = dependency("kotlin-gradle-plugin")
    }

    object StdLib {
        val Common = dependency("kotlin-stdlib-common")
        val Js = dependency("kotlin-stdlib-js")
        val Jvm = dependency("kotlin-stdlib")
    }

    object Test {
        val AnnotationsCommon = dependency("kotlin-test-annotations-common")
        val Common = dependency("kotlin-test-common")
        val JUnit5 = dependency("kotlin-test-junit5")
        val Js = dependency("kotlin-test-js")
        val Jvm = dependency("kotlin-test")
    }
}

object Node : Group("com.moowork.gradle", "1.3.1") {
    const val Plugin = "com.moowork.node"

    object Gradle {
        val Plugin = dependency("gradle-node-plugin")
    }
}
