package com.andres.ceiba.data.di

import com.andres.ceiba.data.remote.CeibaApi
import com.andres.ceiba.data.repositories.PostsByUserIdRepositoryImpl
import com.andres.ceiba.data.repositories.PostsRepositoryImpl
import com.andres.ceiba.data.repositories.UsersRepositoryImpl
import com.andres.ceiba.data.utils.Constants.BASE_URL
import com.andres.ceiba.domain.repositories.PostsByUserIdRepository
import com.andres.ceiba.domain.repositories.PostsRepository
import com.andres.ceiba.domain.repositories.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CeibaDataModule {

    @Singleton
    @Provides
    fun provideOKHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(client)
        .build()


    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): CeibaApi = retrofit.create()

    @Singleton
    @Provides
    fun provideUserRepository(api: CeibaApi): UsersRepository = UsersRepositoryImpl(api)

    @Singleton
    @Provides
    fun providePostsRepository(api: CeibaApi): PostsRepository = PostsRepositoryImpl(api)

    @Singleton
    @Provides
    fun providePostsByUserIdRepository(api: CeibaApi): PostsByUserIdRepository = PostsByUserIdRepositoryImpl(api)
}