package com.andres.ceiba.domain.model.users

import com.andres.ceiba.data.utils.Constants.EMPTY

data class Address(
    val city: String = EMPTY,
    val geo: Geo = Geo(),
    val street: String = EMPTY,
    val suite: String = EMPTY,
    val zipcode: String = EMPTY,
)