@file:Suppress("ClassName")

package deps

object dokka : Group("org.jetbrains.dokka", "0.10.1") {
    object gradle {
        val plugin = artifact("dokka-gradle-plugin")
    }
}

object kotlin : Group("org.jetbrains.kotlin", "1.3.72") {
    object coroutines : Group("org.jetbrains.kotlinx", "1.3.7") {
        object core {
            val common = artifact("kotlinx-coroutines-core-common")
            val jvm = artifact("kotlinx-coroutines-core")
            val native = artifact("kotlinx-coroutines-core-native")
        }
    }

    object gradle {
        val plugin = artifact("kotlin-gradle-plugin")
    }

    object stdlib {
        val common = artifact("kotlin-stdlib-common")
    }

    object test {
        val annotations_common = artifact("kotlin-test-annotations-common")
        val common = artifact("kotlin-test-common")
        val junit5 = artifact("kotlin-test-junit5")
        val jvm = artifact("kotlin-test")
    }
}
