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

// بدلاً من register سنستخدم named لضبط المهمة الموجودة أصلاً وتعطيلها
tasks.named("extractDebugAnnotations") {
    enabled = false
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    // نعود للنسخة المستقرة التي تم التعرف عليها بنجاح
    "compileOnly"("com.github.lagradost:cloudstream3:master-SNAPSHOT")
    "implementation"("org.jsoup:jsoup:1.17.2")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
