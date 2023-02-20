package com.andres.ceiba.domain.repositories.local

import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.UsersItem
import kotlinx.coroutines.flow.Flow

interface CeibaRepositoryLocal {

    suspend fun insertUsersDB(usersList: List<UsersItem>)

    suspend fun insertPostsDB(postsList: List<PostsItem>)

    suspend fun insertPostsByUserId(postsByUserIdList: List<PostByUserIdItem>)

    fun getUsersFromDB(): Flow<List<UsersItem>?>

    fun getPostsFromDB(): Flow<List<PostsItem>?>

    fun getPostByUserIdFromDB(): Flow<List<PostByUserIdItem>?>

    suspend fun deleteUsers()

    suspend fun deletePosts()

    suspend fun deletePostsByUserId()
}