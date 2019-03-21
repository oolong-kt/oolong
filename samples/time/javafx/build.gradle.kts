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
    implementation(project(":samples:time:core"))
    implementation(deps.Kotlin.StdLib)
    implementation(deps.Kotlin.Coroutines.JavaFX)
    implementation(deps.TornadoFX)
}
