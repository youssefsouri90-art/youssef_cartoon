// ملف: /settings.gradle.kts (في المجلد الرئيسي للمستودع)

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    // هذا السطر ضروري جداً لمنع تعارض المستودعات وحل مشكلة الـ 401 Unauthorized
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        // المستودع الذي يحتوي على مكتبة Cloudstream الأساسية
        maven { url = uri("https://jitpack.io") }
    }
}

// اسم المستودع الخاص بك
rootProject.name = "youssef_cartoon"

// أهم سطر: ربط كود موقع كاراطين بعملية البناء
include(":CarateenProvider")
