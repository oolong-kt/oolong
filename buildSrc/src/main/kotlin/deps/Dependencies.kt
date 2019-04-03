package deps

import deps.dsl.Dependency
import deps.dsl.Dependency.Group

object Android : Group("") {

    object Gradle : Group("com.android.tools.build", "3.3.0") {
        val Plugin = Dependency(this, "gradle")
    }

    object X : Group("") {
        object AppCompat : Group("androidx.appcompat", "1.0.0") {
            override val DEFAULT = Dependency(this, "appcompat")
        }

    }
}

object Dokka : Group("org.jetbrains.dokka", "0.9.18") {
    object Gradle : Group(this) {
        val Plugin = Dependency(this, "dokka-gradle-plugin")
    }
}

object Kotlin : Group("org.jetbrains.kotlin", "1.3.21") {
    private const val BASE = "kotlin"

    object Coroutines : Group("org.jetbrains.kotlinx", "1.1.1") {
        private const val BASE = "kotlinx-coroutines"
        val Android = Dependency(this, "$BASE-android")
        val JavaFX = Dependency(this, "$BASE-javafx")
        val Swing = Dependency(this, "$BASE-swing")

        object Core : Group(this) {
            private const val BASE = "${Coroutines.BASE}-core"
            val Common = Dependency(this, "$BASE-common")
            val JS = Dependency(this, "$BASE-js")
            val Native = Dependency(this, "$BASE-native")
            override val DEFAULT = Dependency(this, BASE)
        }
    }

    object Gradle : Group(this) {
        val Plugin = Dependency(this, "kotlin-gradle-plugin")
    }

    object Html : Group("org.jetbrains.kotlinx", "0.6.10") {
        private const val BASE = "kotlinx-html"
        val JS = Dependency(this, "$BASE-js")
        val JVM = Dependency(this, "$BASE-jvm")
    }

    object StdLib : Group(this) {
        private const val BASE = "kotlin-stdlib"
        val Common = Dependency(this, "$BASE-common")
        val JDK8 = Dependency(this, "$BASE-jdk8")
        val JS = Dependency(this, "$BASE-js")
        override val DEFAULT = Dependency(this, BASE)
    }

    object Test : Group(this) {
        private const val BASE = "kotlin-test"
        val AnnotationsCommon = Dependency(this, "$BASE-annotations-common")
        val Common = Dependency(this, "$BASE-common")
        val JS = Dependency(this, "$BASE-js")
        val JVM = Dependency(this, BASE)
        val JUnit5 = Dependency(this, "$BASE-junit5")
        override val DEFAULT = Dependency(this, BASE)
    }
}

object Node : Group("com.moowork.gradle", "1.3.1") {
    const val Plugin = "com.moowork.node"

    object Gradle : Group(this) {
        val Plugin = Dependency(this, "gradle-node-plugin")
    }
}

object TornadoFX : Group("no.tornado", "1.7.18") {
    override val DEFAULT = Dependency(this, "tornadofx")
}
