package com.andres.ceiba.data.repositories

import com.andres.ceiba.data.remote.CeibaApi
import com.andres.ceiba.domain.model.users.Users
import com.andres.ceiba.domain.repositories.UsersRepository

class UsersRepositoryImpl(
    private val ceibaApi: CeibaApi
): UsersRepository {
    override suspend fun getUsers(): Result<Users> {
        return try {
            val result = ceibaApi.getUsers()
            Result.success(result)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}