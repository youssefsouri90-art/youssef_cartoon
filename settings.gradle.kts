pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    // هذا السطر يمنع التعارض بين ملف الإعدادات وملفات البناء الأخرى
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        google()
        mavenCentral()
        // هذا هو المستودع الضروري لجلب مكتبة Cloudstream
        maven("https://jitpack.io") 
    }
}

// اسم المشروع (يمكنك تركه كما هو أو تغييره)
rootProject.name = "youssef_cartoon"

// التأكد من تضمين مجلد الإضافة في عملية البناء
include(":CarateenProvider")
