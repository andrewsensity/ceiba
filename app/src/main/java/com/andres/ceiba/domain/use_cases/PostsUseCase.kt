package com.andres.ceiba.domain.use_cases

import com.andres.ceiba.domain.repositories.PostsRepository

class PostsUseCase(
    private val postsRepository: PostsRepository,
) {

    suspend operator fun invoke() = postsRepository.getPosts()
}