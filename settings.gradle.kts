pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://nexus.infore-robotics.cn/repository/android_local/")
        }
    }
    versionCatalogs {
        create("deps") {
            from("com.infore.robot:version-catalog:1.0.0")
        }
    }
}
// 开启 VERSION_CATALOGS
enableFeaturePreview("VERSION_CATALOGS")

rootProject.name = "version-catalog"
include(":app")
include(":versionCatalog")


