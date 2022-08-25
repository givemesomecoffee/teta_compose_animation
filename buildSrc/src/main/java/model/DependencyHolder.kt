package model

import groovy.lang.Closure
import org.gradle.api.Action
import org.gradle.api.artifacts.Dependency
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.project
class DependencyHolder(
    val version: String,
    val packageAdr: String,
    val type: String = IMPLEMENTATION,
    val forceVersion: Boolean = false
){
    companion object{
        const val IMPLEMENTATION = "implementation"
        const val TEST ="testImplementation"
        const val DEBUG = "debugImplementation"
        const val TEST_ANDROID = "androidTestImplementation"
    }
}