import com.android.build.gradle.internal.tasks.factory.dependsOn

buildscript {
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
        classpath("org.jetbrains.kotlinx:kover:0.6.1")
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:3.5.0.2730")
    }
}

sonar {
    val exclusion = listOf(
        "**/model/**"
    )
    properties {
        property("sonar.projectKey", "ceiba")
        property("sonar.host.url", "http://localhost:9000")
        property("sonar.login", "admin")
        property("sonar.password", "060409")
        property("sonar.sourceEncoding", "UTF-8")
        property("sonar.exclusions", exclusion)
        property("sonar.coverage.jacoco.xmlReportPaths", "$buildDir/reports/kover/merged/xml/report.xml")
    }
}

//tasks.sonarqube.dependsOn(":clean")
tasks.sonarqube.dependsOn(":koverMergedReport")

apply(plugin = "kover")

koverMerged {
    enable()
    xmlReport {
        onCheck.set(true)
    }
    htmlReport {
        onCheck.set(true)
    }
    verify {
        onCheck.set(true)
    }
    filters {
        classes {
            excludes += listOf(
                "com.andres.ceiba.presentation.*",
                "*model.*"
            )
        }
    }
}

plugins {
    id("com.android.application") version "7.4.1" apply false
    id("com.android.library") version "7.4.1" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id("org.jetbrains.kotlin.jvm") version "1.7.20" apply false
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    id("org.sonarqube") version "3.5.0.2730"
}