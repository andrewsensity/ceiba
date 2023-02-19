package com.andres.ceiba.data.repositories.remote

import com.andres.ceiba.data.remote.CeibaApi
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserId
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.repositories.remote.GetPostsByUserIdRepository

class GetPostsByUserIdRepositoryImpl(
    private val ceibaApi: CeibaApi,
) : GetPostsByUserIdRepository {

    override suspend fun getPostsByUserId(userId: Int): Result<List<PostByUserIdItem>> {
        return try {
            val result = ceibaApi.getPostsByUserId(userId)
            Result.success(result)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}