package com.andres.ceiba.domain.model.users

import com.andres.ceiba.data.utils.Constants.EMPTY
import com.andres.ceiba.data.utils.Constants.ZERO

data class UsersItem(
    val address: Address = Address(),
    val company: Company = Company(),
    val email: String = EMPTY,
    val id: Int = ZERO,
    val name: String = EMPTY,
    val phone: String = EMPTY,
    val username: String = EMPTY,
    val website: String = EMPTY,
)