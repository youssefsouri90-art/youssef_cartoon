import com.android.build.gradle.LibraryExtension
import com.lagradost.cloudstream3.gradle.CloudstreamExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply(plugin = "com.android.library")
apply(plugin = "kotlin-android")
apply(plugin = "com.lagradost.cloudstream3.gradle")

configure<CloudstreamExtension> {
    // سيقوم النظام بجلب اسم المستودع تلقائياً
    setRepo(System.getenv("GITHUB_REPOSITORY") ?: "youssef_cartoon")
}

configure<CloudstreamExtension> {
    setRepo(System.getenv("GITHUB_REPOSITORY") ?: "youssef_cartoon")
    // لا نضع إعدادات إضافية هنا لتقليل احتمالية الخطأ
}
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

// حل مشكلة jvmTarget و Unresolved reference: kotlinOptions
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "1.8"
        // إيقاف التحذيرات التي قد تعيق البناء
        freeCompilerArgs = freeCompilerArgs + "-Xjvm-default=all"
    }
}

dependencies {
    // الطريقة البديلة والأكثر استقراراً لجلب مكتبة كلاود ستريم
    val libVersion = "master-SNAPSHOT" 
    add("implementation", "com.github.lagradost:cloudstream3:$libVersion")
    
    // تأكد من أن هذه المكتبات موجودة أيضاً
    add("implementation", "org.jsoup:jsoup:1.17.2")
    add("implementation", "com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
    
    // سطر إضافي لضمان عدم البحث عن JAR خارجي إذا فشل التقييم
    compileOnly("com.github.lagradost:cloudstream3:$libVersion")
}
