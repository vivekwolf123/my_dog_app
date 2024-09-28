plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.client.vivekwolf.android.core_dog_domain"
    hilt {
        enableAggregatingTask = false
    }
}

dependencies {

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(project(":core_dog_data"))
    api(project(":core_base"))
}
