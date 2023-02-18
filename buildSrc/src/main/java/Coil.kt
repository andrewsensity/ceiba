import org.gradle.api.artifacts.dsl.DependencyHandler

object Coil {
    private const val coilVersion = "2.2.2"
    private const val compose = "io.coil-kt:coil-compose:2.2.2"
    private const val svg = "io.coil-kt:coil-svg:2.2.2"

    fun DependencyHandler.coil(){
        implementation(compose)
        implementation(svg)
    }
}