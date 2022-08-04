import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

allprojects {
    group = project.property("GROUP") as String
    version = project.property("VERSION_NAME") as String

    repositories { mavenCentral() }

    tasks.withType<DokkaTask>().configureEach {
        dokkaSourceSets.configureEach {
            reportUndocumented.set(false)
            skipDeprecated.set(true)
            jdkVersion.set(8)
        }

        if (name == "dokkaHtml") {
            outputDirectory.set(file("${rootDir}/docs"))
        }
    }

    plugins.withId("com.vanniktech.maven.publish.base") {
        configure<MavenPublishBaseExtension> {
            publishToMavenCentral(SonatypeHost.DEFAULT)
            signAllPublications()
            pom {
                description.set("MVU for Kotlin Multiplatform")
                name.set(project.name)
                url.set("https://github.com/oolong-kt/oolong/")
                licenses {
                    license {
                        name.set("The Apache Software License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                    }
                }
                scm {
                    url.set("https://github.com/oolong-kt/oolong/")
                    connection.set("scm:git:git://github.com/oolong-kt/oolong.git")
                    developerConnection.set("scm:git:ssh://git@github.com/oolong-kt/oolong.git")
                }
                developers {
                    developer {
                        id.set("oolong")
                        name.set("Oolong")
                    }
                }
            }
        }
    }
}
