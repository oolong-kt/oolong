import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    kotlin("jvm")
    id("org.jetbrains.dokka")
}

repositories {
    jcenter()
    maven("https://dl.bintray.com/jetbrains/spek")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.20")

    testImplementation("com.google.truth:truth:0.42")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.3.20")
    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.0-rc.1")
    testImplementation("org.spekframework.spek2:spek-runner-junit5:2.0.0-rc.1")
    testImplementation("org.mockito:mockito-core:2.24.0")
}


tasks {
    getting(Test::class) {
        useJUnitPlatform {
            includeEngines("spek2")
        }
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
