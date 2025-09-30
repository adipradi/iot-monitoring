plugins {
    id("com.android.application")
    id("com.google.gms.google-services") // wajib ada
}

android {
    namespace = "com.test.iotmonitor"   // SAMA dgn package & manifest
    compileSdk = 34

    defaultConfig {
        applicationId = "com.test.iotmonitor" // sesuai Firebase
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    // Import Firebase BOM
    implementation(platform("com.google.firebase:firebase-bom:34.3.0"))

    // Firebase Analytics (wajib minimal 1 lib)
    implementation("com.google.firebase:firebase-analytics")

    // Realtime Database
    implementation("com.google.firebase:firebase-database")

    // Optional
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-messaging")

    // UI tambahan
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
}
