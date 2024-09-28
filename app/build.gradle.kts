plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.client.vivekwolf.android.mydogapp"
    hilt {
        enableAggregatingTask = false
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.compose.material3)
    implementation(libs.material)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(project(":ui_utils"))
    implementation(project(":navigation"))
    implementation(project(":feature_home"))
    implementation(project(":feature_dog_activity"))
    implementation(project(":feature_dog_facts"))
    implementation(project(":feature_dog_info"))
    implementation(project(":feature_tabs"))
    implementation(project(":core_dog_domain"))
    implementation(project(":core_dog_data"))
    implementation(project(":core_base"))
}