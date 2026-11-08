plugins {
    id("monkeysphone.packages.android.application")
    id("monkeysphone.packages.android.application.compose")
    id("monkeysphone.packages.android.hilt")
    id("monkeysphone.packages.android.http")


//    alias(libs.plugins.kotlin.android)

//    alias(libs.plugins.kotlin.serialization)
//    alias(libs.plugins.compose.compiler)
//    alias(libs.plugins.ksp)
//    alias(libs.plugins.hilt)

}

android {
    namespace = "sjw.core.monkeysphone"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "sjw.core.monkeysphone"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    debugImplementation(libs.androidx.compose.ui.tooling)

//    implementation(libs.okhttp)
//    implementation(libs.okhttp.logging)
//    implementation(libs.retrofit)
//    implementation(libs.retrofit.gson)
//    implementation("com.google.dagger:hilt-android:2.59.2")
//    ksp("com.google.dagger:hilt-android-compiler:2.59.2")
//    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation("com.squareup.picasso:picasso:2.8")
    implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.8")
//    implementation(libs.kotlinx.serialization.json)


    //core
//    implementation(project(":core:network"))
    implementation(project(":packages:core:designsystem"))
    implementation(project(":packages:feature:home"))



}