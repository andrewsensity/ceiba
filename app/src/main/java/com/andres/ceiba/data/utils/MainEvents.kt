package com.andres.ceiba.data.utils

import com.andres.ceiba.domain.model.users.UsersItem

sealed class MainEvents {
    data class OnClickPostsByUserId(
        val id: Int,
        val user: UsersItem,
    ) : MainEvents()
}
