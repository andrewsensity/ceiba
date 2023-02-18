package com.andres.ceiba.domain.use_cases.remote

import com.andres.ceiba.domain.repositories.remote.GetPostsRepository

class GetPostsUseCase(
    private val getPostsRepository: GetPostsRepository,
) {

    suspend operator fun invoke() = getPostsRepository.getPosts()
}