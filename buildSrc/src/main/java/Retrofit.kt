import org.gradle.api.artifacts.dsl.DependencyHandler

object Retrofit {
    private const val retrofitVersion = "2.9.0"
    private const val okHttpVersion = "5.0.0-alpha.2"

    private const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVersion"
    private const val converterGson = "com.squareup.retrofit2:converter-gson:$retrofitVersion"
    private const val okHttp = "com.squareup.okhttp3:okhttp:$okHttpVersion"
    private const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$okHttpVersion"
    private const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"

    fun DependencyHandler.retrofit(){
        implementation(retrofit)
        implementation(converterGson)
        implementation(okHttp)
        implementation(okHttpLoggingInterceptor)
        implementation(moshiConverter)
    }
}