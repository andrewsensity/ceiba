package com.andres.ceiba.domain.use_cases

data class CeibaUseCases(
    val usersUseCase: UsersUseCase,
    val postsUseCase: PostsUseCase,
    val postsByUserIdUseCase: PostsByUserIdUseCase
)
