import com.android.build.gradle.LibraryExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.android.library")
    id("kotlin-android")
}

configure<LibraryExtension> {
    namespace = "com.momen.carateen"
    compileSdk = 34
    defaultConfig { minSdk = 21 }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

// تعطيل المهمة التي تسبب الفشل بسبب نقص صلاحيات السيرفر
tasks.named("extractDebugAnnotations") {
    enabled = false
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    // تغيير النداء لنسخة لا تسبب خطأ 401 في JitPack
    "compileOnly"("com.lagradost:cloudstream3:3.0.0")
    "implementation"("org.jsoup:jsoup:1.17.2")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
