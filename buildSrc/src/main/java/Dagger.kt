import org.gradle.api.artifacts.dsl.DependencyHandler

object Dagger {
    private const val daggerHiltVersion = "2.43.2"
    private const val hilt = "com.google.dagger:hilt-android:$daggerHiltVersion"
    private const val compilerKapt = "com.google.dagger:hilt-android-compiler:$daggerHiltVersion"

    fun DependencyHandler.dagger() {
        implementation(hilt)
        kapt(compilerKapt)
    }
}