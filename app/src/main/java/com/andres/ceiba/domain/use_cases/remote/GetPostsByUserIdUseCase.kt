package com.andres.ceiba.domain.use_cases.remote

import com.andres.ceiba.domain.repositories.remote.GetPostsByUserIdRepository

class GetPostsByUserIdUseCase(
    private val getPostsByUserIdRepository: GetPostsByUserIdRepository,
) {

    suspend operator fun invoke(userId: Int) = getPostsByUserIdRepository.getPostsByUserId(userId)
}