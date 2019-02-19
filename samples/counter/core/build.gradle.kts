import oolong.Dependencies

plugins {
    kotlin("jvm")
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":oolong"))
    implementation(Dependencies.Kotlin.StdLib)
}