package dependencies

import model.DependencyHolder

object Dependencies {

    val compose = listOf(
        //https://issuetracker.google.com/issues/227767363
        DependencyHolder(
            packageAdr = "androidx.customview:customview:",
            type = DependencyHolder.DEBUG,
            version = Versions.CUSTOM_VIEW
        ),
        DependencyHolder(
            packageAdr = "androidx.customview:customview-poolingcontainer:",
            type = DependencyHolder.DEBUG,
            version = Versions.CUSTOM_VIEW_POOLING
        ),
        DependencyHolder(
            packageAdr = "androidx.activity:activity",
            version = "1.5.0-beta01",
            forceVersion = true
        ),
        DependencyHolder(
            packageAdr = "androidx.compose.material:material",
            version = Versions.COMPOSE,
            forceVersion = true
        ), // end of fixed deps
        DependencyHolder(
            packageAdr = "androidx.compose.ui:ui:",
            version = Versions.COMPOSE
        ),
        DependencyHolder(
            packageAdr = "androidx.compose.ui:ui-tooling-preview:",
            version = Versions.COMPOSE,
            type = DependencyHolder.DEBUG
        ),
        DependencyHolder(
            packageAdr = "androidx.activity:activity-compose:",
            version = Versions.COMPOSE_ACTIVITY
        ),
        DependencyHolder(
            packageAdr = "androidx.compose.ui:ui-tooling:",
            version = Versions.COMPOSE
        ),
        DependencyHolder(
            packageAdr = "androidx.compose.ui:ui-test-junit4:",
            version = Versions.COMPOSE
        )
    )

    val test = listOf(
        DependencyHolder(
            packageAdr = "junit:junit:",
            type = DependencyHolder.TEST,
            version = Versions.JUNIT
        ),
        DependencyHolder(
            packageAdr = "androidx.test.ext:junit:",
            type = DependencyHolder.TEST_ANDROID,
            version = Versions.JUNIT_ANDROID
        ),
        DependencyHolder(
            packageAdr = "androidx.test.espresso:espresso-core:",
            type = DependencyHolder.TEST_ANDROID,
            version = Versions.ESPRESSO
        )
    )

    val core = listOf(
        DependencyHolder(
            packageAdr = "androidx.appcompat:appcompat:",
            version = Versions.APP_COMPAT
        ),
        DependencyHolder(
            packageAdr = "androidx.core:core-ktx:",
            version = Versions.ANDROID_CORE
        ),
        DependencyHolder(
            packageAdr = "androidx.lifecycle:lifecycle-runtime-ktx:",
            version = Versions.LIFECYCLE
        )
    )
}