package com.andres.ceiba.data.repositories.remote

import com.andres.ceiba.data.remote.CeibaApi
import com.andres.ceiba.data.utils.Utils
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.moshi.MoshiConverterFactory

class GetPostsByUserIdRepositoryImplTest {
    private lateinit var getPostsByUserIdRepositoryImpl: GetPostsByUserIdRepositoryImpl
    private lateinit var ceibaApi: CeibaApi
    private lateinit var mockWebServer: MockWebServer
    private lateinit var okHttpClient: OkHttpClient

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        okHttpClient = OkHttpClient.Builder()
            .writeTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .connectTimeout(1, TimeUnit.SECONDS)
            .build()
        ceibaApi = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .baseUrl(mockWebServer.url("/"))
            .build()
            .create(CeibaApi::class.java)
        getPostsByUserIdRepositoryImpl = GetPostsByUserIdRepositoryImpl(ceibaApi)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `Get posts by user id, valid response, returns success`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(Utils.readJsonFile("200_get_posts_by_user_id.json"))
        )
        val result = getPostsByUserIdRepositoryImpl.getPostsByUserId(1)
        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `Get posts by user id, invalid response, returns failure`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(400)
                .setBody(Utils.readJsonFile("200_get_posts_by_user_id.json"))
        )
        val result = getPostsByUserIdRepositoryImpl.getPostsByUserId(1)
        assertThat(result.isFailure).isTrue()
    }

    @Test
    fun `Get posts by user id, malformed response, returns success`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse()
                .setBody(malformedGetPostByUserId)
        )
        val result = getPostsByUserIdRepositoryImpl.getPostsByUserId(1)
        assertThat(result.isFailure).isTrue()
    }
}