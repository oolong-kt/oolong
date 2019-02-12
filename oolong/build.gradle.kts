import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka")
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("com.google.truth:truth:0.42")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.3.20")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.2.1")
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
