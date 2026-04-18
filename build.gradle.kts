buildscript {
    // هنا نترك المستودعات فقط لأنها ضرورية لـ Plugins
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.20")
        classpath("com.github.recloudstream:gradle:master-SNAPSHOT")
    }
}

// قمنا بحذف بلوك allprojects { repositories { ... } } لأنه يسبب التعارض
