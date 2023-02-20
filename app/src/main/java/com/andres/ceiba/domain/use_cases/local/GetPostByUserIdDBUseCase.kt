package com.andres.ceiba.domain.use_cases.local

import com.andres.ceiba.domain.repositories.local.CeibaRepositoryLocal

class GetPostByUserIdDBUseCase(
    private val ceibaRepositoryLocal: CeibaRepositoryLocal,
) {

    operator fun invoke(/*userId: Int*/) = ceibaRepositoryLocal.getPostByUserIdFromDB()
}
