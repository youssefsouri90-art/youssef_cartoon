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

// الخدعة البرمجية: إنشاء الملف المفقود يدوياً لإرضاء Gradle
tasks.register("createMissingTypedefs") {
    doFirst {
        val file = file("build/intermediates/annotations_typedef_file/debug/typedefs.txt")
        if (!file.exists()) {
            file.parentFile.mkdirs()
            file.writeText("") // إنشاء ملف فارغ
        }
    }
}

// إجبار المهمة الفاشلة على الانتظار حتى ننشئ الملف
tasks.named("syncDebugLibJars") {
    dependsOn("createMissingTypedefs")
}

tasks.configureEach {
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
