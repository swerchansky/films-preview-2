buildscript {
    project.extra.apply {
        set("applicationId", "swerchansky.films.preview")
        set("compileSdkVersion", 33)
        set("buildToolsVersion", "33.0.1")
        set("minSdkVersion", 24)
        set("targetSdkVersion", 33)
        set("versionCode", 1)
        set("versionName", "1.0")
        set("testInstrumentationRunner", "androidx.test.runner.AndroidJUnitRunner")

        set("coreKtxVersion", "1.9.0")
        set("lifeCycleVersion", "2.6.2")
        set("activityComposeVersion", "1.7.0")
        set("coroutinesVersion", "1.3.9")
        set("daggerVersion", "2.40")
        set("retrofitVersion", "2.5.0")
        set("retrofitConverterVersion", "2.3.0")
        set("jacksonVersion", "2.15.2")

        set("junitVersion", "4.13.2")
        set("supportTestVersion", "1.1.5")
        set("espressoVersion", "3.5.1")

        set(
            "appDependencies", mapOf(
                "androidCoreKtx" to "androidx.core:core-ktx:${extra["coreKtxVersion"]}",
                "androidLifecycle" to "androidx.lifecycle:lifecycle-runtime-ktx:${extra["lifeCycleVersion"]}",
                "activityCompose" to "androidx.activity:activity-compose:${extra["activityComposeVersion"]}",
                "dagger" to "com.google.dagger:dagger:${extra["daggerVersion"]}",
                "daggerCompiler" to "com.google.dagger:dagger-compiler:${extra["daggerVersion"]}",
                "coroutines" to "org.jetbrains.kotlinx:kotlinx-coroutines-android:${extra["coroutinesVersion"]}",
            )
        )

        set(
            "appTestDependencies", mapOf(
                "junit" to "junit:junit:${extra["junitVersion"]}",
                "supportJunit" to "androidx.test.ext:junit:${extra["supportTestVersion"]}",
                "espresso" to "androidx.test.espresso:espresso-core:${extra["espressoVersion"]}"
            )
        )

        set(
            "dataDependencies", mapOf(
                "androidCoreKtx" to "androidx.core:core-ktx:${extra["coreKtxVersion"]}",
                "dagger" to "com.google.dagger:dagger:${extra["daggerVersion"]}",
                "retrofit" to "com.squareup.retrofit2:retrofit:${extra["retrofitVersion"]}",
                "retrofitJackson" to "com.squareup.retrofit2:converter-jackson:${extra["retrofitConverterVersion"]}",
                "retrofitScalars" to "com.squareup.retrofit2:converter-scalars:${extra["retrofitConverterVersion"]}",
                "jackson" to "com.fasterxml.jackson.module:jackson-module-kotlin:${extra["jacksonVersion"]}",
                "daggerCompiler" to "com.google.dagger:dagger-compiler:${extra["daggerVersion"]}",
            )
        )

        set(
            "dataTestDependencies", mapOf(
                "junit" to "junit:junit:${extra["junitVersion"]}",
                "supportJunit" to "androidx.test.ext:junit:${extra["supportTestVersion"]}",
                "espresso" to "androidx.test.espresso:espresso-core:${extra["espressoVersion"]}"
            )
        )

        set(
            "domainDependencies", mapOf(
                "androidCoreKtx" to "androidx.core:core-ktx:${extra["coreKtxVersion"]}",
                "activityCompose" to "androidx.activity:activity-compose:${extra["activityComposeVersion"]}",
                "dagger" to "com.google.dagger:dagger:${extra["daggerVersion"]}",
            )
        )

        set(
            "domainTestDependencies", mapOf(
                "junit" to "junit:junit:${extra["junitVersion"]}",
            )
        )
    }
}

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}