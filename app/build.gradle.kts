plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.poc_facial_recognition"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.poc_facial_recognition"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.legacy.support.v4)
    implementation (libs.facedetection)

    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.3.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0")

    implementation (libs.androidx.navigation.fragment)
    implementation (libs.androidx.navigation.ui)

    implementation (libs.retrofit)
    implementation (libs.converter.gson)
    implementation (libs.kprogresshud)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}