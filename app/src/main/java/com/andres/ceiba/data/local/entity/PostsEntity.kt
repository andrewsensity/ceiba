package com.andres.ceiba.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andres.ceiba.data.utils.Constants.TABLE_POSTS
import com.andres.ceiba.domain.model.posts.PostsItem

@Entity(tableName = TABLE_POSTS)
data class PostsEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val posts: List<PostsItem>
)
