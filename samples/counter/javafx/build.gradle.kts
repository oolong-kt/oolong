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
    implementation(project(":samples:counter:core"))
    implementation(deps.Kotlin.StdLib)
    implementation(deps.Kotlin.Coroutines.Core)
    implementation(deps.Kotlin.Coroutines.JavaFX)
    implementation(deps.TornadoFX)
}
