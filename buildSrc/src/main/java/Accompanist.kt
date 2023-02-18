import org.gradle.api.artifacts.dsl.DependencyHandler

object Accompanist {
    private const val accompanistVersion = "0.25.0"
    private const val pager = "com.google.accompanist:accompanist-pager:$accompanistVersion"
    private const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:0.17.0"
    private const val animation ="com.google.accompanist:accompanist-navigation-animation:0.25.1"

    fun DependencyHandler.accompanist(){
        implementation(pager)
        implementation(systemUiController)
        implementation(animation)
    }
}