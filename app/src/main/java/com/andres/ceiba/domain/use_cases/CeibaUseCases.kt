package com.andres.ceiba.domain.use_cases

import com.andres.ceiba.domain.use_cases.local.*
import com.andres.ceiba.domain.use_cases.remote.GetPostsByUserIdUseCase
import com.andres.ceiba.domain.use_cases.remote.GetPostsUseCase
import com.andres.ceiba.domain.use_cases.remote.GetUsersUseCase

data class CeibaUseCases(
    val getUsersUseCase: GetUsersUseCase,
    val getPostsUseCase: GetPostsUseCase,
    val getPostsByUserIdUseCase: GetPostsByUserIdUseCase,
    val insertUsersDBUseCase: InsertUsersDBUseCase,
    val insertPostsDBUseCase: InsertPostsDBUseCase,
    val insertPostByUserIdDBUseCase: InsertPostByUserIdDBUseCase,
    val getUsersDBUseCase: GetUsersDBUseCase,
    val getPostsDBUseCase: GetPostsDBUseCase,
    val getPostByUserIdDBUseCase: GetPostByUserIdDBUseCase,
    val deleteUsersUseCase: DeleteUsersUseCase,
    val deletePostsUseCase: DeletePostsUseCase,
    val deletePostsByUserIdUseCase: DeletePostsByUserIdUseCase
)
