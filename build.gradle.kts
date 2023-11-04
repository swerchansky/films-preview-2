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
        set("daggerVersion", "2.16")

        set("junitVersion", "4.13.2")
        set("supportTestVersion", "1.1.5")
        set("espressoVersion", "3.5.1")

        set(
            "appDependencies", mapOf(
                "androidCoreKtx" to "androidx.core:core-ktx:${extra["coreKtxVersion"]}",
                "androidLifecycle" to "androidx.lifecycle:lifecycle-runtime-ktx:${extra["lifeCycleVersion"]}",
                "activityCompose" to "androidx.activity:activity-compose:${extra["activityComposeVersion"]}",
                "dagger" to "com.google.dagger:dagger:${extra["daggerVersion"]}",
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

        set(
            "presentationDependencies", mapOf(
                "androidCoreKtx" to "androidx.core:core-ktx:${extra["coreKtxVersion"]}",
                "androidLifecycle" to "androidx.lifecycle:lifecycle-runtime-ktx:${extra["lifeCycleVersion"]}",
                "activityCompose" to "androidx.activity:activity-compose:${extra["activityComposeVersion"]}",
                "dagger" to "com.google.dagger:dagger:${extra["daggerVersion"]}",
                "coroutines" to "org.jetbrains.kotlinx:kotlinx-coroutines-android:${extra["coroutinesVersion"]}",
            )
        )

        set(
            "presentationTestDependencies", mapOf(
                "junit" to "junit:junit:${extra["junitVersion"]}",
                "supportJunit" to "androidx.test.ext:junit:${extra["supportTestVersion"]}",
                "espresso" to "androidx.test.espresso:espresso-core:${extra["espressoVersion"]}"
            )
        )
    }
}

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}