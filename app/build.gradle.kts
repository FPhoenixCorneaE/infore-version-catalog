plugins {
    alias(deps.plugins.android.application)
    alias(deps.plugins.kotlin.android)
}

android {
    compileSdk = deps.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.infore.version.catalog"
        minSdk = deps.versions.minSdk.get().toInt()
        targetSdk = deps.versions.targetSdk.get().toInt()
        versionCode = 100
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
    namespace = "com.infore.version.catalog"
}

dependencies {

    implementation(deps.androidx.core.ktx)
    implementation(deps.androidx.appcompat)
    implementation(deps.material)
    implementation(deps.androidx.constraintlayout)
    // compose
    debugImplementation(deps.androidx.compose.ui.tooling)
    implementation(deps.bundles.compose)
    implementation(deps.androidx.activity.compose)
    implementation(deps.androidx.lifecycle.viewmodel.compose)

    testImplementation(deps.test.junit.junit)
    androidTestImplementation(deps.test.junit.ktx)
    androidTestImplementation(deps.test.espresso.core)
}

