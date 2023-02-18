package com.andres.ceiba.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andres.ceiba.data.utils.Constants.TABLE_POSTS
import com.andres.ceiba.data.utils.Constants.TABLE_POSTS_BY_USER_ID
import com.andres.ceiba.domain.model.posts.PostsItem

@Entity(tableName = TABLE_POSTS_BY_USER_ID)
data class PostByUserIdEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val body: String,
    val title: String,
    val userId: Int
)
