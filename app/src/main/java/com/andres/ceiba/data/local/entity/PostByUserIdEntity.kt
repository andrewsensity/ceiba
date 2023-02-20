package com.andres.ceiba.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andres.ceiba.data.utils.Constants.TABLE_POSTS_BY_USER_ID
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem

@Entity(tableName = TABLE_POSTS_BY_USER_ID)
data class PostByUserIdEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val postByUserId: List<PostByUserIdItem>? = null,
)
