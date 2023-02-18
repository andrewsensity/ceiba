package com.andres.ceiba.domain.repositories

import com.andres.ceiba.domain.model.posts.Posts

interface PostsRepository {

    suspend fun getPosts(): Result<Posts>
}