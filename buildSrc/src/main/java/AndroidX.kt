import org.gradle.api.artifacts.dsl.DependencyHandler

object AndroidX {
    private const val coreKtx = "androidx.core:core-ktx:1.9.0"
    private const val pagingVersion = "3.1.1"

    private const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    private const val activityCompose = "androidx.activity:activity-compose:1.6.0"
    private const val paging = "androidx.paging:paging-runtime:3.1.1"

    fun DependencyHandler.androidX(){
        implementation(coreKtx)
        implementation(lifecycleRuntime)
        implementation(activityCompose)
        implementation(paging)
    }
}