package model

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