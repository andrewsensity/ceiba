package com.andres.ceiba.domain.repositories

import com.andres.ceiba.domain.model.posts.PostsItem

interface PostsByUserIdRepository {

    suspend fun getPostsByUserId(userId: Int): Result<PostsItem>
}