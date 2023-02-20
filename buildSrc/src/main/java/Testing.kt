import org.gradle.api.artifacts.dsl.DependencyHandler

object Testing {
    private const val mockWebServerVersion = "4.9.3"
    private const val truthVersion = "1.1.3"
    private const val uiTestJunitVersion = "1.3.3"
    private const val mockkVersion = "1.12.4"

    private const val jUnit4 = "junit:junit:4.13.2"
    private const val jUnitExt = "androidx.test.ext:junit:1.1.3"
    private const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
    private const val composeUiTestJUnit4 = "androidx.compose.ui:ui-test-junit4:$uiTestJunitVersion"
    private const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Compose.composeVersion}"
    private const val composeUiTest = "androidx.compose.ui:ui-test-manifest:${Compose.composeVersion}"
    private const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$mockWebServerVersion"
    private const val truth = "com.google.truth:truth:$truthVersion"
    private const val mockk = "io.mockk:mockk:$mockkVersion"
    private const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"

    fun DependencyHandler.test() {
        testImplementation(jUnit4)
        testImplementation(mockWebServer)
        testImplementation(truth)
        testImplementation(mockk)
        testImplementation(mockkAndroid)
    }

    fun DependencyHandler.androidTest() {
        androidTestImplementation(jUnitExt)
        androidTestImplementation(espressoCore)
        androidTestImplementation(composeUiTestJUnit4)
        androidTestImplementation(truth)
    }

    fun DependencyHandler.debug() {
        debugImplementation(composeUiTooling)
        debugImplementation(composeUiTest)
    }
}