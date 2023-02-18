package com.andres.ceiba.domain.repositories.local

import com.andres.ceiba.domain.model.posts.Posts
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.Users
import com.andres.ceiba.domain.model.users.UsersItem
import kotlinx.coroutines.flow.Flow

interface CeibaRepositoryLocal {

    suspend fun insertUsersDB(usersList: List<UsersItem>)

    suspend fun insertPostsDB(postsList: List<PostsItem>)

    fun getUsersFromDB(): Flow<List<UsersItem>>

    fun getPostsFromDB(): Flow<List<PostsItem>>

    fun getPostByUserIdFromDB(userId: Int): Flow<PostsItem>
}