import org.gradle.api.artifacts.dsl.DependencyHandler

object Compose {
    const val compilerVersion = "1.3.2"
    const val composeVersion = "1.3.3"
    private const val navigationVersion = "2.5.2"
    private const val hiltNavigationComposeVersion = "1.0.0"
    private const val iconsVersion = "1.3.1"
    private const val material3Version = "1.0.1"

    private const val ui = "androidx.compose.ui:ui:$composeVersion"
    private const val navigation = "androidx.navigation:navigation-compose:$navigationVersion"
    private const val util = "androidx.compose.ui:ui-util:$composeVersion"
    private const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"
    private const val pagingCompose = "androidx.paging:paging-compose:1.0.0-alpha13"
    private const val icons = "androidx.compose.material:material-icons-extended:$iconsVersion"
    private const val runtime = "androidx.compose.runtime:runtime:$composeVersion"
    private const val material3 = "androidx.compose.material3:material3:$material3Version"
    private const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$composeVersion"

    fun DependencyHandler.compose() {
        implementation(ui)
        implementation(toolingPreview)
        implementation(material3)
        implementation(navigation)
        implementation(util)
        implementation(hiltNavigationCompose)
        implementation(pagingCompose)
        implementation(icons)
        implementation(runtime)
    }
}