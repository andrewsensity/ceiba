import org.gradle.api.artifacts.dsl.DependencyHandler

object Room {
    private const val roomVersion = "2.4.2"

    private const val runtime = "androidx.room:room-runtime:$roomVersion"
    private const val ktx = "androidx.room:room-ktx:$roomVersion"
    private const val compilerKapt = "androidx.room:room-compiler:$roomVersion"

    fun DependencyHandler.room() {
        implementation(runtime)
        implementation(ktx)
        kapt(compilerKapt)
    }
}