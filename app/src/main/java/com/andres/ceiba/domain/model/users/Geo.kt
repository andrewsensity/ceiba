package com.andres.ceiba.domain.model.users

import com.andres.ceiba.data.utils.Constants.EMPTY

data class Geo(
    val lat: String = EMPTY,
    val lng: String = EMPTY,
)