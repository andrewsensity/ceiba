package com.andres.ceiba.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.andres.ceiba.data.local.dao.CeibaDao
import com.andres.ceiba.data.local.entity.PostByUserIdEntity
import com.andres.ceiba.data.local.entity.PostsEntity
import com.andres.ceiba.data.local.entity.UsersEntity
import com.andres.ceiba.data.utils.Constants.DATABASE_VERSION

@Database(
    entities = [UsersEntity::class, PostsEntity::class, PostByUserIdEntity::class],
    version = DATABASE_VERSION
)

@TypeConverters(Converters::class)
abstract class CeibaDatabase : RoomDatabase() {
    abstract val ceibaDao: CeibaDao
}