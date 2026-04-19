import com.lagradost.cloudstream3.gradle.CloudstreamExtension

// استخدام "apply plugin" بدلاً من بلوك "plugins" لتوافق أفضل مع buildscript
apply(plugin = "com.android.library")
apply(plugin = "kotlin-android")
apply(plugin = "com.lagradost.cloudstream3.gradle")

configure<CloudstreamExtension> {
    // تأكد أن الكلاس يطابق ما هو موجود في ملف CarateenPlugin.kt
    setProviderClass("com.momen.CarateenPlugin")
}

android {
    namespace = "com.momen.carateen"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val cloudstreamVersion = "v3.0.1"
    compileOnly("com.github.lagradost:cloudstream3:$cloudstreamVersion")
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
