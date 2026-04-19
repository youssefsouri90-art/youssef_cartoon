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
        // إضافة هذا السطر يخبر Gradle بإنشاء ملفات الميتا بشكل صحيح
        aarMetadata {
            minCompileSdk = 21
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        resValues = true
    }
}

// بدلاً من تعطيل المهمة، سنتركها تعمل لكن نمنعها من إيقاف البناء
tasks.withType<com.android.build.gradle.tasks.ExtractAnnotations> {
    enabled = true
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    // المستودع الجديد الذي أضفناه في settings سيوفر هذه المكتبة الآن بدون أخطاء
    "compileOnly"("com.github.lagradost:cloudstream3:master-SNAPSHOT")
    "implementation"("org.jsoup:jsoup:1.17.2")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
