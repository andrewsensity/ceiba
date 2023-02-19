package com.andres.ceiba.data.utils

sealed class MainEvents {
    data class OnClickPostsByUserId(
        val id: Int,
    ) : MainEvents()
}
