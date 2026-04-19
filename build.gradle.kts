plugins {
    id("com.android.library")
    id("kotlin-android")
    // إضافة البلاجن المسؤول عن تحويل المكتبة إلى إضافة Cloudstream
    id("com.lagradost.cloudstream3.gradle") version "1.0.0"
}

cloudstream {
    // تحديد الكلاس الأساسي الذي يحتوي على منطق جلب البيانات
    setProviderClass("com.momen.carateen.CarateenProvider")
}

android {
    namespace = "com.momen.carateen"
    compileSdk = 34
    
    defaultConfig {
        minSdk = 21
    }
}

dependencies {
    // المكتبات الضرورية التي يعتمد عليها التطبيق
    compileOnly("com.github.lagradost:cloudstream3:v3.0.1")
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
