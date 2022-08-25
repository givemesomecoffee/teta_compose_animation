package plugin

import config.MainConfig
import PluginIds
import dependencies.Dependencies
import helper.android
import helper.applyDependencies
import helper.kotlinOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibrary: Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.run {
            apply(PluginIds.BASE_ANDROID_LIBRARY)
            apply(PluginIds.KOTLIN_ANDROID)
        }
        target.android{
            compileSdk = MainConfig.COMPILE_SDK

            defaultConfig {
                minSdk = MainConfig.MIN_SDK
                targetSdk = MainConfig.COMPILE_SDK
                testInstrumentationRunner = MainConfig.TEST_INSTRUMENTATION_RUNNER
                consumerProguardFiles(MainConfig.CONSUMER_PROGUARD_FILES)
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
                jvmTarget = MainConfig.JVM_TARGET
            }
        }
        target.applyDependencies(
            Dependencies.compose,
            Dependencies.core,
            Dependencies.test
        )
    }
}