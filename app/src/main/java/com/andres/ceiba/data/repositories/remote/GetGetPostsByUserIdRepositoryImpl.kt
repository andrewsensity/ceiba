package com.andres.ceiba.data.repositories.remote

import com.andres.ceiba.data.remote.CeibaApi
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.repositories.remote.GetPostsByUserIdRepository

class GetGetPostsByUserIdRepositoryImpl(
    private val ceibaApi: CeibaApi,
) : GetPostsByUserIdRepository {

    override suspend fun getPostsByUserId(userId: Int): Result<PostsItem> {
        return try {
            val result = ceibaApi.getPostsByUserId(userId)
            Result.success(result)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}