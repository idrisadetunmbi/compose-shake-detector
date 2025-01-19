plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "dev.idrisadetunmbi.composeshakedetector.sample"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.idrisadetunmbi.composeshakedetector.sample"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.compose))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.material3)

    implementation(libs.konfetti.compose)

    implementation(projects.composeShakeDetector)
}