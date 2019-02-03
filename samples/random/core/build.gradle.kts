plugins {
    kotlin("jvm")
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":oolong"))
    implementation(kotlin("stdlib"))
}