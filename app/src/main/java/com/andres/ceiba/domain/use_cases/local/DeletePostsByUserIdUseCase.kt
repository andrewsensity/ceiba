package com.andres.ceiba.domain.use_cases.local

import com.andres.ceiba.domain.repositories.local.CeibaRepositoryLocal

class DeletePostsByUserIdUseCase(
    private val ceibaRepositoryLocal: CeibaRepositoryLocal,
) {
    suspend operator fun invoke() = ceibaRepositoryLocal.deletePostsByUserId()
}