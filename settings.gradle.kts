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

rootProject.name = "MyDogApp"
include(":app")
include(":ui_utils")
include(":navigation")
include(":feature_home")
include(":feature_dog_info")
include(":feature_dog_activity")
include(":feature_dog_facts")
include(":core_dog_domain")
include(":core_dog_data")
include(":core_base")
include(":feature_tabs")
include(":feature_base")
