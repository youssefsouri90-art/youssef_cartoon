pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        // إضافة مستودع البديل لـ JitPack
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://repo.recloudstream.org/repository/maven-public/") }
    }
}

rootProject.name = "youssef_cartoon"
include(":CarateenProvider")
