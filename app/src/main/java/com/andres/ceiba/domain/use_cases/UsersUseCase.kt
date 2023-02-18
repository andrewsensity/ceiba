package com.andres.ceiba.domain.use_cases

import com.andres.ceiba.domain.repositories.UsersRepository

class UsersUseCase(
    private val usersRepository: UsersRepository
) {

    suspend operator fun invoke() = usersRepository.getUsers()
}