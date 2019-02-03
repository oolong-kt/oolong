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
    implementation(project(":oolong"))
    implementation(project(":samples:counter:core"))
    implementation(kotlin("stdlib"))
    implementation("no.tornado:tornadofx:1.7.18")
}