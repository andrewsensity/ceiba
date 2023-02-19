package com.andres.ceiba.domain.model.post_by_user_id

data class PostByUserIdItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)