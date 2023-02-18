package com.andres.ceiba.domain.repositories.remote

import com.andres.ceiba.domain.model.posts.PostsItem

interface GetPostsByUserIdRepository {

    suspend fun getPostsByUserId(userId: Int): Result<PostsItem>
}