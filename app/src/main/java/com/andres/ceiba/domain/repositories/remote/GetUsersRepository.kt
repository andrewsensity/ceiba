package com.andres.ceiba.domain.repositories.remote

import com.andres.ceiba.domain.model.users.Users

interface GetUsersRepository {

    suspend fun getUsers(): Result<Users>
}