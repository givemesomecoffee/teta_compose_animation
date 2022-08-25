package helper

import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import model.DependencyHolder
import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalDependency
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun Project.android(action: LibraryExtension.() -> Unit) =
    (extensions["android"] as LibraryExtension).run(action)

internal fun Project.androidApp(action: BaseAppModuleExtension.() -> Unit) =
    (extensions["android"] as BaseAppModuleExtension).run(action)

internal fun BaseAppModuleExtension.kotlinOptions(action: KotlinJvmOptions.() -> Unit) =
    ((this as ExtensionAware).extensions.getByName("kotlinOptions") as KotlinJvmOptions).run(action)

internal fun LibraryExtension.kotlinOptions(action: KotlinJvmOptions.() -> Unit) =
    ((this as ExtensionAware).extensions.getByName("kotlinOptions") as KotlinJvmOptions).run(action)

fun Project.applyPlugins(list: List<String>) {
    list.map {
        pluginManager.apply(it)
    }
}

fun Project.applyDependencies(vararg dependencies: List<DependencyHolder>) {
    dependencies.forEach {
        it.forEach { dependency ->
            if (dependency.forceVersion) {
                addDependencyTo<ExternalDependency>(
                    this.dependencies,
                    dependency.type,
                    dependency.packageAdr
                ) {
                    version { strictly(dependency.version) }
                }
            } else {
                this.dependencies.add(dependency.type, dependency.packageAdr + dependency.version)
            }
        }
    }
}
