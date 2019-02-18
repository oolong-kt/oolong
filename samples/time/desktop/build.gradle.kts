import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile

plugins {
    kotlin("jvm")
}

repositories {
    jcenter()
}

val compileKotlin by tasks.getting(KotlinJvmCompile::class) {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":oolong-javafx"))
    implementation(project(":samples:time:core"))
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.1.1")
    implementation("no.tornado:tornadofx:1.7.18")
}