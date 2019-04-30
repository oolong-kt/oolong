package deps

import deps.dsl.Dependency
import deps.dsl.Dependency.Group

object Android : Group("") {

    object Gradle : Group("com.android.tools.build", "3.3.0") {
        val Plugin = Dependency(this, "gradle")
    }

    object X : Group("") {
        object AppCompat : Group("androidx.appcompat", "1.0.0") {
            override val default = Dependency(this, "appcompat")
        }
    }
}

object Dokka : Group("org.jetbrains.dokka", "0.9.18") {
    object Gradle : Group(this) {
        val Plugin = Dependency(this, "dokka-gradle-plugin")
    }
}

object Kotlin : Group("org.jetbrains.kotlin", "1.3.30") {
    private const val BASE = "kotlin"

    object Coroutines : Group("org.jetbrains.kotlinx", "1.2.0") {
        private const val BASE = "kotlinx-coroutines"
        val Android = Dependency(this, "$BASE-android")
        val JavaFX = Dependency(this, "$BASE-javafx")
        val Swing = Dependency(this, "$BASE-swing")

        object Core : Group(this) {
            private const val BASE = "${Coroutines.BASE}-core"
            val Common = Dependency(this, "$BASE-common")
            val JS = Dependency(this, "$BASE-js")
            val Native = Dependency(this, "$BASE-native")
            override val default = Dependency(this, BASE)
        }
    }

    object Gradle : Group(this) {
        val Plugin = Dependency(this, "kotlin-gradle-plugin")
    }

    object StdLib : Group(this) {
        private const val BASE = "kotlin-stdlib"
        val Common = Dependency(this, "$BASE-common")
        val JDK8 = Dependency(this, "$BASE-jdk8")
        val JS = Dependency(this, "$BASE-js")
        override val default = Dependency(this, BASE)
    }

    object Test : Group(this) {
        private const val BASE = "kotlin-test"
        val AnnotationsCommon = Dependency(this, "$BASE-annotations-common")
        val Common = Dependency(this, "$BASE-common")
        val JS = Dependency(this, "$BASE-js")
        val JVM = Dependency(this, BASE)
        val JUnit5 = Dependency(this, "$BASE-junit5")
        override val default = Dependency(this, BASE)
    }

    object X : Group("${id}x", version) {
        private const val BASE = "kotlinx"

        object Coroutines : Group(this, "1.2.1") {
            private const val BASE = "${X.BASE}-coroutines"
            val Android = Dependency(this, "$BASE-android")

            object Core : Group(this) {
                private const val BASE = "${X.BASE}-core"
                val Common = Dependency(this, "$BASE-common")
                val JS = Dependency(this, "$BASE-js")
                val Native = Dependency(this, "$BASE-native")
                override val default = Dependency(this, BASE)
            }
        }
    }
}

object Facebook : Group("com.facebook") {

    object Flipper : Group("$id.flipper", "0.20.0") {
        private const val BASE = "flipper"
        override val default = Dependency(this, BASE)
    }

    object Litho : Group("$id.litho", "0.25.0") {
        private const val BASE = "litho"
        override val default = Dependency(this, "$BASE-core")
        val Processor = Dependency(this, "$BASE-processor")
        val Widget = Dependency(this, "$BASE-widget")

        object Sections : Group(this) {
            private const val BASE = "litho-sections"
            override val default = Dependency(this, "$BASE-core")
            val Annotations = Dependency(this, "$BASE-annotations")
            val Processor = Dependency(this, "$BASE-processor")
            val Widget = Dependency(this, "$BASE-widget")
        }
    }

    object SoLoader : Group("$id.soloader", "0.6.0") {
        override val default = Dependency(this, "soloader")
    }

}

object Max : Group("com.michaelpardo", "0.1.0-SNAPSHOT") {
    private const val BASE = "max"
    val Matcher = Dependency(this, "$BASE-matcher")
    val Navigator = Dependency(this, "$BASE-navigator")
    val Router = Dependency(this, "$BASE-router")
}

object Node : Group("com.moowork.gradle", "1.3.1") {
    const val Plugin = "com.moowork.node"

    object Gradle : Group(this) {
        val Plugin = Dependency(this, "gradle-node-plugin")
    }
}

object SQLDelight : Group("com.squareup.sqldelight", "1.1.3") {
    override val default = Dependency(this, "sqlite-driver")
    val Android = Dependency(this, "android-driver")
}
