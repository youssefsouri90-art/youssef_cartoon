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

    // تعطيل المهمة التي تسبب الفشل دائماً (extractDebugAnnotations)
    val extractDebugAnnotations = tasks.register("extractDebugAnnotations") {
        enabled = false
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    // جلب نسخة قديمة ومستقرة جداً لا تتطلب تصريحاً من JitPack
    "compileOnly"("com.github.lagradost:cloudstream3:pre-release")
    "implementation"("org.jsoup:jsoup:1.17.2")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
