import oolong.Dependencies
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka")
}

repositories {
    jcenter()
}

dependencies {
    implementation(Dependencies.Kotlin.StdLib)
    implementation(Dependencies.Kotlin.Coroutines)

    testImplementation(Dependencies.Truth)
    testImplementation(Dependencies.Kotlin.Test)
    testImplementation(Dependencies.KotlinTest.Runner)
}


tasks {
    getting(Test::class) {
        useJUnitPlatform()
    }

    val dokka by getting(DokkaTask::class) {
        outputFormat = "gfm"
        outputDirectory = "docs"

        includes = listOf("src/main/Module.md")

//        linkMapping {
//            dir = "${projectDir}/src/main/kotlin"
//            url = "https://github.com/pardom/oolong/tree/master/oolong/src/main/kotlin"
//            suffix = "#L"
//        }
    }

    getting(GradleBuild::class) {
        dependsOn(dokka)
    }
}

apply(from = rootProject.file("gradle/gradle-mvn-push.gradle"))
