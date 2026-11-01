plugins {
    id("monkeysphone.packages.android.library")
    id("monkeysphone.packages.android.library.compose")

}

android {
    namespace = "sjw.core.monkeysphone.compose.core.designsystem"
}

dependencies {
    // image loading

    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.compose.runtime)             // 추가
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.graphics)
    api(libs.androidx.compose.foundation.layout)   // 추가
    api(libs.androidx.compose.ui.tooling.preview)
}