package com.andres.ceiba.domain.use_cases.remote

import com.andres.ceiba.domain.repositories.remote.GetUsersRepository

class GetUsersUseCase(
    private val getUsersRepository: GetUsersRepository
) {

    suspend operator fun invoke() = getUsersRepository.getUsers()
}