import oolong.Dependencies

plugins {
    id("kotlin2js")
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":samples:counter:core"))
    implementation(Dependencies.Kotlin.Coroutines.Core.JS)
    implementation(Dependencies.Kotlin.Html.JS)
}
