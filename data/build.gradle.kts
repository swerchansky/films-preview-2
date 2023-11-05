plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    val dataDependencies = rootProject.extra["dataDependencies"] as Map<*, *>
    val dataTestDependencies = rootProject.extra["dataTestDependencies"] as Map<*, *>

    implementation(dataDependencies["androidCoreKtx"].toString())
    implementation(dataDependencies["dagger"].toString())
    implementation(dataDependencies["retrofit"].toString())
    implementation(dataDependencies["retrofitJackson"].toString())
    implementation(dataDependencies["retrofitScalars"].toString())
    implementation(dataDependencies["jackson"].toString())
    kapt(dataDependencies["daggerCompiler"].toString())
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.5.0")
    testImplementation(dataTestDependencies["junit"].toString())
    androidTestImplementation(dataTestDependencies["supportJunit"].toString())
    androidTestImplementation(dataTestDependencies["espresso"].toString())

    implementation(project(":domain"))
}