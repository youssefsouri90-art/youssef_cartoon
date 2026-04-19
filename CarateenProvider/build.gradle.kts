import com.android.build.gradle.LibraryExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply(plugin = "com.android.library")
apply(plugin = "kotlin-android")

configure<LibraryExtension> {
    namespace = "com.momen.carateen"
    compileSdk = 34
    defaultConfig { minSdk = 21 }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = "1.8" }
}

dependencies {
    // جلب المكتبة من JitPack مباشرة (هذا الرابط يعمل دائماً)
    compileOnly("com.github.lagradost:cloudstream3:master-SNAPSHOT")
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}

// إنشاء أمر "make" يدوياً بما أن الأصلي معطل
tasks.register("make") {
    dependsOn("assembleDebug")
    doLast {
        println("تهانينا! تم بناء إضافة كاراطين بنجاح.")
    }
}
