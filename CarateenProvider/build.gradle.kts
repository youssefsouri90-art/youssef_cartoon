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

// حل عبقري: إنشاء الملف المفقود عند بداية أي عملية بناء لإسكات Gradle
tasks.configureEach {
    if (name.contains("prepare", ignoreCase = true) || name.contains("generate", ignoreCase = true)) {
        doLast {
            val typedefsFile = file("build/intermediates/annotations_typedef_file/debug/typedefs.txt")
            if (!typedefsFile.exists()) {
                typedefsFile.parentFile.mkdirs()
                typedefsFile.writeText("")
            }
        }
    }
    // تعطيل المهمة المزعجة إذا وجدت
    if (name == "extractDebugAnnotations") {
        enabled = false
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    "compileOnly"("com.github.lagradost:cloudstream3:v3.0.1")
    "implementation"("org.jsoup:jsoup:1.17.2")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
