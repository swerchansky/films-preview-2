plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "swerchansky.films"
    compileSdk = rootProject.extra["compileSdkVersion"] as Int
    buildToolsVersion = rootProject.extra["buildToolsVersion"].toString()

    defaultConfig {
        multiDexEnabled = true
        applicationId = rootProject.extra["applicationId"].toString()
        minSdk = rootProject.extra["minSdkVersion"] as Int
        targetSdk = rootProject.extra["targetSdkVersion"] as Int
        versionCode = rootProject.extra["versionCode"] as Int
        versionName = rootProject.extra["versionName"].toString()

        testInstrumentationRunner = rootProject.extra["testInstrumentationRunner"].toString()
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val appDependencies = rootProject.extra["appDependencies"] as Map<*, *>
    val appTestDependencies = rootProject.extra["appTestDependencies"] as Map<*, *>

    implementation(appDependencies["androidCoreKtx"].toString())
    implementation(appDependencies["androidLifecycle"].toString())
    implementation(appDependencies["activityCompose"].toString())
    implementation(appDependencies["dagger"].toString())
    implementation("io.coil-kt:coil-compose:2.0.0-rc01")
    kapt(appDependencies["daggerCompiler"].toString())
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation(appTestDependencies["junit"].toString())
    androidTestImplementation(appTestDependencies["supportJunit"].toString())
    androidTestImplementation(appTestDependencies["espresso"].toString())
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation(project(":data"))
    implementation(project(":domain"))
}