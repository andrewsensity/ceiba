package com.andres.ceiba.data.repositories

import com.andres.ceiba.data.remote.CeibaApi
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.repositories.PostsByUserIdRepository

class PostsByUserIdRepositoryImpl(
    private val ceibaApi: CeibaApi,
) : PostsByUserIdRepository {

    override suspend fun getPostsByUserId(userId: Int): Result<PostsItem> {
        return try {
            val result = ceibaApi.getPostsByUserId(userId)
            Result.success(result)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}