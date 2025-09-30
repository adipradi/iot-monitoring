plugins {
    // ... plugin lain kalau ada
    id("com.google.gms.google-services") version "4.4.3" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        // Kalau masih ada plugin lama, hapus
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
