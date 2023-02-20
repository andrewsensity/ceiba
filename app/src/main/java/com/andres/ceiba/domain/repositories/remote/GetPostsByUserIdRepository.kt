package com.andres.ceiba.domain.repositories.remote

import com.andres.ceiba.domain.model.post_by_user_id.PostByUserId

interface GetPostsByUserIdRepository {

    suspend fun getPostsByUserId(userId: Int): Result<PostByUserId>
}