package com.andres.ceiba.domain.model.posts

data class PostsItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)