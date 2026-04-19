plugins {
    id("com.android.library")
    id("kotlin-android")
    // هذا البلجن هو الذي يحول الكود إلى صيغة الإضافات (Dex)
    id("com.lagradost.cloudstream3.gradle") version "1.0.0"
}

cloudstream {
    // هنا نضع اسم الكلاس الذي يحتوي على @CloudstreamPlugin مع الباكج
    setProviderClass("com.momen.CarateenPlugin")
}

android {
    namespace = "com.momen.carateen"
    compileSdk = 34
    defaultConfig { minSdk = 21 }
}

dependencies {
    compileOnly("com.github.lagradost:cloudstream3:v3.0.1")
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
