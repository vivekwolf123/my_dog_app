plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.client.vivekwolf.android.ui_utils"
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.compose.material3)
    implementation(libs.compose.ui)
}
