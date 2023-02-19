package com.andres.ceiba.domain.di

import com.andres.ceiba.domain.repositories.local.CeibaRepositoryLocal
import com.andres.ceiba.domain.repositories.remote.GetPostsByUserIdRepository
import com.andres.ceiba.domain.repositories.remote.GetPostsRepository
import com.andres.ceiba.domain.repositories.remote.GetUsersRepository
import com.andres.ceiba.domain.use_cases.CeibaUseCases
import com.andres.ceiba.domain.use_cases.local.*
import com.andres.ceiba.domain.use_cases.remote.GetPostsByUserIdUseCase
import com.andres.ceiba.domain.use_cases.remote.GetPostsUseCase
import com.andres.ceiba.domain.use_cases.remote.GetUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object CeibaDomainModule {

    @Provides
    @ViewModelScoped
    fun provideCeibaUseCases(
        getUsersRepository: GetUsersRepository,
        getPostsRepository: GetPostsRepository,
        getPostsByUserIdRepository: GetPostsByUserIdRepository,
        ceibaRepositoryLocal: CeibaRepositoryLocal,
    ): CeibaUseCases {
        return CeibaUseCases(
            getUsersUseCase = GetUsersUseCase(getUsersRepository),
            getPostsUseCase = GetPostsUseCase(getPostsRepository),
            getPostsByUserIdUseCase = GetPostsByUserIdUseCase(getPostsByUserIdRepository),
            insertUsersDBUseCase = InsertUsersDBUseCase(ceibaRepositoryLocal),
            insertPostsDBUseCase = InsertPostsDBUseCase(ceibaRepositoryLocal),
            insertPostByUserIdDBUseCase = InsertPostByUserIdDBUseCase(ceibaRepositoryLocal),
            getUsersDBUseCase = GetUsersDBUseCase(ceibaRepositoryLocal),
            getPostsDBUseCase = GetPostsDBUseCase(ceibaRepositoryLocal),
            getPostByUserIdDBUseCase = GetPostByUserIdDBUseCase(ceibaRepositoryLocal),
            deleteUsersUseCase = DeleteUsersUseCase(ceibaRepositoryLocal),
            deletePostsUseCase = DeletePostsUseCase(ceibaRepositoryLocal),
            deletePostsByUserIdUseCase = DeletePostsByUserIdUseCase(ceibaRepositoryLocal)
        )
    }
}