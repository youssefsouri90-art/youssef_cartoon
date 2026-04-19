// ملف: /build.gradle.kts (المجلد الرئيسي)

buildscript {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
    dependencies {
        // تعريف إصدار الأندرويد وكوتلن على مستوى المشروع بالكامل
        classpath("com.android.tools.build:gradle:8.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
        
        // إضافة مكتبة Cloudstream لكي يتعرف عليها النظام في كل مكان
        classpath("com.github.lagradost:cloudstream3:master-SNAPSHOT")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
