package plugin

import config.MainConfig
import PluginIds
import helper.*
import dependencies.*
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

abstract class AndroidApp : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.run {
            apply(PluginIds.BASE_ANDROID_APP)
            apply(PluginIds.KOTLIN_ANDROID)
        }
        project.androidApp {
            compileSdk = MainConfig.COMPILE_SDK
            defaultConfig {
                applicationId = MainConfig.APPLICATION_ID
                minSdk = MainConfig.MIN_SDK
                targetSdk = MainConfig.COMPILE_SDK
                versionCode = MainConfig.VERSION_CODE
                versionName = MainConfig.VERSION_NAME
                testInstrumentationRunner = MainConfig.TEST_INSTRUMENTATION_RUNNER
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

        project.applyDependencies(
            Dependencies.compose,
            Dependencies.core,
            Dependencies.test
        )
    }
}