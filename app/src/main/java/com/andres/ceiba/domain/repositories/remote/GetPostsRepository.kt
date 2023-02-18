package com.andres.ceiba.domain.repositories.remote

import com.andres.ceiba.domain.model.posts.Posts

interface GetPostsRepository {

    suspend fun getPosts(): Result<Posts>
}