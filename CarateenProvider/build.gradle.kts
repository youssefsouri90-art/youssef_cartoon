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
}

dependencies {
    // هذه النسخة متاحة للجميع ولا تتطلب تسجيل دخول (تتخطى خطأ 401)
    "compileOnly"("com.lagradost:cloudstream3:3.2.1") 
    "implementation"("org.jsoup:jsoup:1.17.2")
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions { jvmTarget = "1.8" }
}
