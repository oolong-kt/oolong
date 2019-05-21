import com.moowork.gradle.node.npm.NpmInstallTask
import com.moowork.gradle.node.task.NodeTask
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

val GROUP: String by project
val VERSION_NAME: String by project

group = GROUP
version = VERSION_NAME

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    `maven-publish`
    signing
    id(deps.Node.Plugin)
}

repositories {
    mavenCentral()
    jcenter()
}

kotlin {
    js {
        compilations.forEach {
            it.kotlinOptions {
                moduleKind = "umd"
                sourceMap = true
            }
        }
    }
    jvm()
    iosX64("ios") {
        binaries {
            framework("Oolong")
        }
    }
    linuxX64("linux")
    macosX64("macOS")
    mingwX64("windows")

    cocoapods {
        summary = "MVU for Kotlin Multiplatform"
        homepage = "http://oolong-kt.org"
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(deps.Kotlin.StdLib.Common)
                api(deps.Kotlin.Coroutines.Core.Common)
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test.Common)
                implementation(deps.Kotlin.Test.AnnotationsCommon)
            }
        }

        val jsMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.JS)
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test.JS)
            }
        }

        val jvmMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(deps.Kotlin.Test)
                implementation(deps.Kotlin.Test.JUnit5)
            }
        }

        val iosMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.Native)
            }
        }

        val linuxMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.Native)
            }
        }

        val macOSMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.Native)
            }
        }

        val windowsMain by getting {
            dependencies {
                api(deps.Kotlin.Coroutines.Core.Native)
            }
        }
    }
}

node {
    download = true
}

tasks {
    val compileKotlinJs by getting(Kotlin2JsCompile::class)
    val compileTestKotlinJs by getting(Kotlin2JsCompile::class)
    val npmInstall by getting(NpmInstallTask::class)

    val clean by getting {
        delete("$rootDir/docs/oolong")
    }

    val build by getting {
        dependsOn("dokka")
    }

    val copyJsArtifacts by creating(Copy::class) {
        dependsOn(compileKotlinJs)
        from(compileKotlinJs.destinationDir)
        from(compileTestKotlinJs.destinationDir)
        into("$buildDir/node_modules")
    }

    val runJest by creating(NodeTask::class) {
        dependsOn(compileTestKotlinJs, copyJsArtifacts, npmInstall)
        setScript(file("node_modules/jest/bin/jest.js"))
        setArgs(mutableListOf(projectDir.toURI().relativize(compileTestKotlinJs.outputFile.toURI())))
    }

    val jsTest by getting {
        dependsOn(runJest)
    }
}

// workaround for https://github.com/srs/gradle-node-plugin/issues/301
repositories.whenObjectAdded {
    if (this is IvyArtifactRepository) {
        metadataSources {
            artifact()
        }
    }
}

// workaround for https://youtrack.jetbrains.com/issue/KT-27170
configurations {
    create("compileClasspath")
}

apply("$rootDir/gradle/gradle-mvn-mpp-push.gradle")
