plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "swerchansky.films.presentation"
    compileSdk = rootProject.extra["compileSdkVersion"] as Int
    buildToolsVersion = rootProject.extra["buildToolsVersion"].toString()

    defaultConfig {
        minSdk = rootProject.extra["minSdkVersion"] as Int
        targetSdk = rootProject.extra["targetSdkVersion"] as Int

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    val presentationDependencies = rootProject.extra["presentationDependencies"] as Map<*, *>
    val presentationTestDependencies = rootProject.extra["presentationTestDependencies"] as Map<*, *>

    implementation(presentationDependencies["androidCoreKtx"].toString())
    implementation(presentationDependencies["androidLifecycle"].toString())
    implementation(presentationDependencies["activityCompose"].toString())
    implementation(presentationDependencies["dagger"].toString())
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation(presentationTestDependencies["junit"].toString())
    androidTestImplementation(presentationTestDependencies["supportJunit"].toString())
    androidTestImplementation(presentationTestDependencies["espresso"].toString())
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation(project(":domain"))
}