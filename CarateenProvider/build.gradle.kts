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

// هذه هي الطريقة الصحيحة والآمنة لتعطيل المهمة دون حذفها
tasks.configureEach {
    if (name == "extractDebugAnnotations") {
        enabled = false
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    // استخدمنا الإصدار v3.0.1 مع المسار الكامل (هذا الإصدار موجود ومستقر)
    "compileOnly"("com.github.lagradost:cloudstream3:v3.0.1")
    "implementation"("org.jsoup:jsoup:1.17.2")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
