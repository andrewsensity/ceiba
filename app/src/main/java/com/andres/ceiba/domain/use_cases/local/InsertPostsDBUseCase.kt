package com.andres.ceiba.domain.use_cases.local

import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.repositories.local.CeibaRepositoryLocal

class InsertPostsDBUseCase(
    private val ceibaRepositoryLocal: CeibaRepositoryLocal,
) {

    suspend operator fun invoke(postsList: ArrayList<PostsItem>) =
        ceibaRepositoryLocal.insertPostsDB(postsList)
}