package com.andres.ceiba.domain.use_cases

import com.andres.ceiba.domain.repositories.PostsByUserIdRepository

class PostsByUserIdUseCase(
    private val postsByUserIdRepository: PostsByUserIdRepository,
) {

    suspend operator fun invoke(userId: Int) = postsByUserIdRepository.getPostsByUserId(userId)
}