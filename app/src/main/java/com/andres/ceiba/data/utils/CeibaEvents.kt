package com.andres.ceiba.data.utils

sealed class CeibaEvents {
    data class OnClickPostsByUserId(
        val id: Int,
    ) : CeibaEvents()
}
