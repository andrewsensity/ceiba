package com.andres.ceiba.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.andres.ceiba.data.utils.Constants.TABLE_USERS
import com.andres.ceiba.domain.model.users.UsersItem

@Entity(tableName = TABLE_USERS)
data class UsersEntity(
    @PrimaryKey(autoGenerate = false) val id: Int = 0,
    val users: List<UsersItem>,
)