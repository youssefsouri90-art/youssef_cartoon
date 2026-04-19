pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    // إجبار المشروع على استخدام الإعدادات المذكورة هنا فقط لمنع تعارض الصلاحيات
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        // المستودع الأساسي لجلب مكتبة Cloudstream
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "youssef_cartoon"
include(":CarateenProvider")
