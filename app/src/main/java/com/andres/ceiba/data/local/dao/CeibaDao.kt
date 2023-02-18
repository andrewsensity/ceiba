package com.andres.ceiba.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.andres.ceiba.data.local.entity.PostByUserIdEntity
import com.andres.ceiba.data.local.entity.PostsEntity
import com.andres.ceiba.data.local.entity.UsersEntity
import com.andres.ceiba.data.utils.Constants.TABLE_POSTS
import com.andres.ceiba.data.utils.Constants.TABLE_POSTS_BY_USER_ID
import com.andres.ceiba.data.utils.Constants.TABLE_USERS
import kotlinx.coroutines.flow.Flow

@Dao
interface CeibaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsersDB(users: UsersEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPostsDB(posts: PostsEntity)

    @Query("SELECT * FROM $TABLE_USERS")
    fun getUsersFromDB(): Flow<UsersEntity>

    @Query("SELECT * FROM $TABLE_POSTS")
    fun getPostsFromDB(): Flow<PostsEntity>

    @Query("SELECT * FROM $TABLE_POSTS_BY_USER_ID")
    fun getPostByUserIdFromDB(): Flow<PostByUserIdEntity>
}