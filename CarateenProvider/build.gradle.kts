import com.android.build.gradle.LibraryExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// سنستخدم إضافات الأندرويد الأساسية فقط ونتجنب إضافة كلاود ستريم المتعطلة حالياً
apply(plugin = "com.android.library")
apply(plugin = "kotlin-android")

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
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // تحميل المكتبة مباشرة من JitPack لتجنب خطأ الـ JAR
    compileOnly("com.github.lagradost:cloudstream3:master-SNAPSHOT")
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
