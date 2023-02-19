package com.andres.ceiba.data.remote

import com.andres.ceiba.data.utils.Constants.POSTS
import com.andres.ceiba.data.utils.Constants.USERS
import com.andres.ceiba.data.utils.Constants.USER_ID
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserId
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.model.posts.Posts
import com.andres.ceiba.domain.model.users.Users
import retrofit2.http.GET
import retrofit2.http.Query

interface CeibaApi {

    @GET(USERS)
    suspend fun getUsers(): Users

    @GET(POSTS)
    suspend fun getPosts(): Posts

    @GET(POSTS)
    suspend fun getPostsByUserId(
        @Query(USER_ID) userId: Int,
    ): List<PostByUserIdItem>
}