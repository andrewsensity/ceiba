package com.andres.ceiba.data.utils

sealed class PostsEvents {
    data class GetPostsByUserId(
        val id: Int,
    ) : PostsEvents()
}
