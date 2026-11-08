plugins {

    id("monkeysphone.packages.android.library")
    id("monkeysphone.packages.android.hilt")
    id("monkeysphone.packages.android.json")
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
    ksp(libs.hilt.compiler)
    implementation(libs.kotlinx.serialization.json)
    implementation(project(":packages:library:network"))
}