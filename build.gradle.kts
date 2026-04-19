buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2")
        // استخدام هذا الإصدار تحديداً لأنه الأكثر استقراراً على سيرفرات JitPack
        classpath("com.github.lagradost:cloudstream3-gradle:6.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.22")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}
