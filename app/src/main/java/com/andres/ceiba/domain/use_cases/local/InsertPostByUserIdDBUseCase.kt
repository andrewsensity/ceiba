package com.andres.ceiba.domain.use_cases.local

import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.repositories.local.CeibaRepositoryLocal

class InsertPostByUserIdDBUseCase(
    private val ceibaRepositoryLocal: CeibaRepositoryLocal,
) {

    suspend operator fun invoke(postByUserIdItem: List<PostByUserIdItem>) =
        ceibaRepositoryLocal.insertPostsByUserId(postByUserIdItem)
}