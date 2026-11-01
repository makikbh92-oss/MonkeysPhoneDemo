pluginManagement {
    includeBuild("packages/build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MonkeysPhoneDemo"
include(":app")
include(":packages:build-logic")
include(":packages:build-logic:convention")
include(":packages:core:network")
include(":packages:core:designsystem")
include(":packages:feature:home")
include(":packages:feature:etc")
