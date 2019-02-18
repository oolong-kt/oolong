plugins {
    kotlin("jvm")
}

repositories {
    jcenter()
}

dependencies {
    api(project(":oolong"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.1.1")
}

apply(from = rootProject.file("gradle/gradle-mvn-push.gradle"))