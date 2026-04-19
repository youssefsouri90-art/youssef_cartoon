import com.android.build.gradle.LibraryExtension
import com.lagradost.cloudstream3.gradle.CloudstreamExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// أعدنا تفعيل الإضافات الثلاث الأساسية
apply(plugin = "com.android.library")
apply(plugin = "kotlin-android")
apply(plugin = "com.lagradost.cloudstream3.gradle")

configure<CloudstreamExtension> {
    // هذا السطر يربط الإضافة بمستودعك على GitHub
    setRepo(System.getenv("GITHUB_REPOSITORY") ?: "youssef_cartoon")
}

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
    // الطريقة الصحيحة والمجربة لربط المكتبة
    val cloudstream by configurations.getting
    add(cloudstream.name, "com.github.lagradost:cloudstream3:master-SNAPSHOT")
    
    add("implementation", "org.jsoup:jsoup:1.17.2")
    add("implementation", "com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
