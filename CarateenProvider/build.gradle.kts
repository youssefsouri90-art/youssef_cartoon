import com.android.build.gradle.LibraryExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    id("kotlin-android")
}

configure<LibraryExtension> {
    namespace = "com.momen.carateen"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    // تعطيل استخراج التنبيهات لحل مشكلة التوقف عند 90%
    buildFeatures {
        resValues = true
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // ربط مكتبة Cloudstream الأساسية
    "compileOnly"("com.github.lagradost:cloudstream3:master-SNAPSHOT")
    
    // المكتبات اللازمة لسحب وتحليل محتوى موقع كاراطين
    "implementation"("org.jsoup:jsoup:1.17.2")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}

// إنشاء مهمة بناء يدوية لتوليد ملف الإضافة
tasks.register("make") {
    dependsOn("assembleDebug")
}
