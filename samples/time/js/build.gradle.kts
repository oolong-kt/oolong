import oolong.Dependencies

plugins {
    id("kotlin2js")
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":samples:time:core"))
    implementation(Dependencies.Kotlin.Coroutines.Core.JS)
    implementation(Dependencies.Kotlin.Html.JS)
}
