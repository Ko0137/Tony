pluginManagement {
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
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "L.i.r.a."
include(":app")
include(":core:ui")
include(":core:data")
include(":core:voice")
include(":core:ai")
include(":feature:chat")
include(":feature:vibe")
include(":feature:finance")
include(":feature:notes")
include(":feature:settings")
