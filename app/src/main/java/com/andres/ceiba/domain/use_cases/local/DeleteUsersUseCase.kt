package com.andres.ceiba.domain.use_cases.local

import com.andres.ceiba.domain.repositories.local.CeibaRepositoryLocal

class DeleteUsersUseCase(
    private val ceibaRepositoryLocal: CeibaRepositoryLocal,
) {
    suspend operator fun invoke() = ceibaRepositoryLocal.deleteUsers()
}