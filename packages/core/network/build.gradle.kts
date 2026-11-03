plugins {

    id("monkeysphone.packages.android.library")
    id("monkeysphone.packages.android.hilt")
    id("monkeysphone.packages.android.http")
    id("org.jetbrains.kotlin.plugin.serialization")

}

android {
    namespace = "sjw.core.monkeysphone.compose.core.network"

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(libs.hilt.core)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit)
    implementation(libs.kotlinx.serialization.json)
    implementation("com.squareup.retrofit2:converter-kotlinx-serialization:3.0.0")
    ksp(libs.hilt.compiler)
}