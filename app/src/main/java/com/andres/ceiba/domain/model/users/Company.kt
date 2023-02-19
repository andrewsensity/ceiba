package com.andres.ceiba.domain.model.users

import com.andres.ceiba.data.utils.Constants.EMPTY

data class Company(
    val bs: String = EMPTY,
    val catchPhrase: String = EMPTY,
    val name: String = EMPTY,
)