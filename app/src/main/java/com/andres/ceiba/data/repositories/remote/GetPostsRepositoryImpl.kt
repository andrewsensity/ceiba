package com.andres.ceiba.data.repositories.remote

import com.andres.ceiba.data.remote.CeibaApi
import com.andres.ceiba.domain.model.posts.Posts
import com.andres.ceiba.domain.repositories.remote.GetPostsRepository

class GetPostsRepositoryImpl(
    private val ceibaApi: CeibaApi,
) : GetPostsRepository {

    override suspend fun getPosts(): Result<Posts> {
        return try {
            val result = ceibaApi.getPosts()
            Result.success(result)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}