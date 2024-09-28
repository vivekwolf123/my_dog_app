plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.client.vivekwolf.android.core_dog_data"
    hilt {
        enableAggregatingTask = false
    }
    defaultConfig {
        buildConfigField("String", "DOG_FACTS_API", "\"https://api.coincap.io/v2/\"")
    }
    buildFeatures {
        buildConfig = true
    }
    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

dependencies {

    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)

    implementation(libs.retrofit.converter.gson)
    api(libs.retrofit)

    implementation(libs.gson)

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.kotlinx.serialization.json)

    implementation(project(":core_base"))
}