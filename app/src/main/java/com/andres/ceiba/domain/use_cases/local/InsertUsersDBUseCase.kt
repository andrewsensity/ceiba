package com.andres.ceiba.domain.use_cases.local

import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.domain.repositories.local.CeibaRepositoryLocal

class InsertUsersDBUseCase(
    private val ceibaRepositoryLocal: CeibaRepositoryLocal
) {

    suspend operator fun invoke(usersList: ArrayList<UsersItem>) =
        ceibaRepositoryLocal.insertUsersDB(usersList)
}