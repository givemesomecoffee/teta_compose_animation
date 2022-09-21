plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.2.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
    implementation("com.github.lalyos:jfiglet:0.0.9")
    gradleApi()
}

gradlePlugin {
    plugins {
        register("AndroidApp") {
            id = "android-app-custom"
            implementationClass = "plugin.AndroidApp"
        }
        register("AndroidLibrary") {
            id = "android-library-custom"
            implementationClass = "plugin.AndroidLibrary"
        }
    }
}