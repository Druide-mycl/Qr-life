plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.qrife"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.qrife"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            isMinifyEnabled = false
        }
    }

    packaging {
        resources.excludes += setOf("META-INF/DEPENDENCIES")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.webkit:webkit:1.11.0")

    // AdMob (Test-IDs in Layout/MainActivity)
    implementation("com.google.android.gms:play-services-ads:23.3.0")

    // Play Billing (In-App-Käufe)
    implementation("com.android.billingclient:billing-ktx:7.0.0")

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
}
