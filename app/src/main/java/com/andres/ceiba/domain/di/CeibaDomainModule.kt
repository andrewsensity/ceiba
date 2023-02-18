package com.andres.ceiba.domain.di

import com.andres.ceiba.domain.repositories.PostsByUserIdRepository
import com.andres.ceiba.domain.repositories.PostsRepository
import com.andres.ceiba.domain.repositories.UsersRepository
import com.andres.ceiba.domain.use_cases.CeibaUseCases
import com.andres.ceiba.domain.use_cases.PostsByUserIdUseCase
import com.andres.ceiba.domain.use_cases.PostsUseCase
import com.andres.ceiba.domain.use_cases.UsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object CeibaDomainModule {

    @Provides
    @ViewModelScoped
    fun provideCeibaUseCases(
        usersRepository: UsersRepository,
        postsRepository: PostsRepository,
        postsByUserIdRepository: PostsByUserIdRepository,
    ): CeibaUseCases {
        return CeibaUseCases(
            usersUseCase = UsersUseCase(usersRepository),
            postsUseCase = PostsUseCase(postsRepository),
            postsByUserIdUseCase = PostsByUserIdUseCase(postsByUserIdRepository)
        )
    }
}