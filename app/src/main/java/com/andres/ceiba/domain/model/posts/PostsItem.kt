package com.andres.ceiba.domain.model.posts

import com.andres.ceiba.data.utils.Constants.EMPTY
import com.andres.ceiba.data.utils.Constants.ZERO

data class PostsItem(
    val body: String = EMPTY,
    val id: Int = ZERO,
    val title: String = EMPTY,
    val userId: Int = ZERO,
)