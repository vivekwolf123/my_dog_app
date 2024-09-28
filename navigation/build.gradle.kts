plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.client.vivekwolf.android.navigation"
}

dependencies {

    implementation(libs.compose.material3)
}
