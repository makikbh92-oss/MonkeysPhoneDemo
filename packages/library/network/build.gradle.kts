plugins {
    id("monkeysphone.packages.android.library")
    id("monkeysphone.packages.android.hilt")
    id("monkeysphone.packages.android.http")
    id("monkeysphone.packages.android.json")
}

android {
    namespace = "sjw.core.monkeysphone.compose.library.network"

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
    implementation(libs.timber)
    ksp(libs.hilt.compiler)
}