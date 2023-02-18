package com.andres.ceiba.data.repositories

import com.andres.ceiba.data.remote.CeibaApi
import com.andres.ceiba.domain.model.posts.Posts
import com.andres.ceiba.domain.repositories.PostsRepository

class PostsRepositoryImpl(
    private val ceibaApi: CeibaApi,
) : PostsRepository {

    override suspend fun getPosts(): Result<Posts> {
        return try {
            val result = ceibaApi.getPosts()
            Result.success(result)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}