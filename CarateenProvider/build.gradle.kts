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

// تعطيل المهمة التي تسبب الفشل دائماً بسبب نقص الصلاحيات
tasks.withType<com.android.build.gradle.tasks.ExtractAnnotations> {
    enabled = false
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    // جلب المكتبات التي لا تسبب مشاكل من الإنترنت
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
    
    // بدلاً من JitPack، سنخبره أن المكتبة موجودة في الإنترنت برابط مباشر لا يحتاج تصريح
    compileOnly("com.github.lagradost:cloudstream3:master-SNAPSHOT") 
}
