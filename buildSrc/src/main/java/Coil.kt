import org.gradle.api.artifacts.dsl.DependencyHandler

object Coil {
    private const val coilVersion = "2.2.2"
    private const val compose = "io.coil-kt:coil-compose:$coilVersion"
    private const val svg = "io.coil-kt:coil-svg:$coilVersion"
    private const val coilGif = "io.coil-kt:coil-gif:$coilVersion"

    fun DependencyHandler.coil(){
        implementation(compose)
        implementation(svg)
        implementation(coilGif)
    }
}