package com.andres.ceiba.domain.use_cases.local

import com.andres.ceiba.domain.repositories.local.CeibaRepositoryLocal

class DeletePostsUseCase(
    private val ceibaRepositoryLocal: CeibaRepositoryLocal,
) {
    suspend operator fun invoke() = ceibaRepositoryLocal.deletePosts()
}