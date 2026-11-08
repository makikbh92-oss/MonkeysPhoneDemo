plugins {
    `kotlin-dsl`
}

group = "sjw.core.monkeysphone.compose.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.compose.compiler.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)

}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "monkeysphone.packages.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "monkeysphone.packages.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "monkeysphone.packages.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "monkeysphone.packages.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "monkeysphone.packages.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "monkeysphone.packages.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidHttp") {
            id = "monkeysphone.packages.android.http"
            implementationClass = "AndroidHttpConventionPlugin"
        }
        register("androidJson") {
            id = "monkeysphone.packages.android.json"
            implementationClass = "AndroidSerializationConventionPlugin"
        }
    }
}