package com.andres.ceiba.data.di

import android.content.Context
import androidx.room.Room
import com.andres.ceiba.data.local.CeibaDatabase
import com.andres.ceiba.data.remote.CeibaApi
import com.andres.ceiba.data.repositories.local.CeibaRepositoryLocalImpl
import com.andres.ceiba.data.repositories.remote.GetPostsByUserIdRepositoryImpl
import com.andres.ceiba.data.repositories.remote.GetPostsRepositoryImpl
import com.andres.ceiba.data.repositories.remote.GetUsersRepositoryImpl
import com.andres.ceiba.data.utils.Constants.BASE_URL
import com.andres.ceiba.data.utils.Constants.DATABASE_CEIBA
import com.andres.ceiba.domain.repositories.local.CeibaRepositoryLocal
import com.andres.ceiba.domain.repositories.remote.GetPostsByUserIdRepository
import com.andres.ceiba.domain.repositories.remote.GetPostsRepository
import com.andres.ceiba.domain.repositories.remote.GetUsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideUserRepository(api: CeibaApi): GetUsersRepository = GetUsersRepositoryImpl(api)

    @Singleton
    @Provides
    fun providePostsRepository(api: CeibaApi): GetPostsRepository = GetPostsRepositoryImpl(api)

    @Singleton
    @Provides
    fun providePostsByUserIdRepository(api: CeibaApi): GetPostsByUserIdRepository =
        GetPostsByUserIdRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideCeibaRepositoryLocal(ceibaDatabase: CeibaDatabase): CeibaRepositoryLocal =
        CeibaRepositoryLocalImpl(ceibaDatabase.ceibaDao)

    @Singleton
    @Provides
    fun provideCeibaDatabase(@ApplicationContext context: Context): CeibaDatabase {
        return Room.databaseBuilder(context, CeibaDatabase::class.java, DATABASE_CEIBA)
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }
}