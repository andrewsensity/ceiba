package com.andres.ceiba.domain.repositories

import com.andres.ceiba.domain.model.users.Users

interface UsersRepository {

    suspend fun getUsers(): Result<Users>
}