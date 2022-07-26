@file:Suppress("ClassName")

package deps

object dokka : Group("org.jetbrains.dokka", "0.10.1") {
    object gradle {
        val plugin = artifact("dokka-gradle-plugin")
    }
}

object kotlin : Group("org.jetbrains.kotlin", "1.7.10") {
    object coroutines : Group("org.jetbrains.kotlinx", "1.6.4") {
        val core = artifact("kotlinx-coroutines-core")
        val test = artifact("kotlinx-coroutines-test")
    }

    object gradle {
        val plugin = artifact("kotlin-gradle-plugin")
    }

    object test {
        val annotations_common = artifact("kotlin-test-annotations-common")
        val common = artifact("kotlin-test-common")
        val junit = artifact("kotlin-test-junit")
        val jvm = artifact("kotlin-test")
    }
}
