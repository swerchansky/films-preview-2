plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "swerchansky.films.data"
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
    val dataDependencies = rootProject.extra["dataDependencies"] as Map<*, *>
    val dataTestDependencies = rootProject.extra["dataTestDependencies"] as Map<*, *>

    implementation(dataDependencies["androidCoreKtx"].toString())
    implementation(dataDependencies["dagger"].toString())
    testImplementation(dataTestDependencies["junit"].toString())
    androidTestImplementation(dataTestDependencies["supportJunit"].toString())
    androidTestImplementation(dataTestDependencies["espresso"].toString())

    implementation(project(":domain"))
}