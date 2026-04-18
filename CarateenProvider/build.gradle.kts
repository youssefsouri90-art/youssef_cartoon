import com.android.build.gradle.BaseExtension
import com.lagradost.cloudstream3.gradle.CloudstreamExtension

apply(plugin = "com.android.library")
apply(plugin = "kotlin-android")
apply(plugin = "com.lagradost.cloudstream3.gradle")

configure<CloudstreamExtension> {
    setRepo(System.getenv("GITHUB_REPOSITORY") ?: "youssefsouri90-art/carateen-extension")
}

configure<BaseExtension> {
    namespace = "com.momen.carateen"
    compileSdkVersion(34)

    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    val cloudstream by configurations.creating
    add(cloudstream.name, "com.github.lagradost:cloudstream3:master-SNAPSHOT")
    add("implementation", "org.jsoup:jsoup:1.17.2")
    add("implementation", "com.fasterxml.jackson.module:jackson-module-kotlin:2.16.1")
}
