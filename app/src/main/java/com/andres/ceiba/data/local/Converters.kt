package com.andres.ceiba.data.local

import androidx.room.TypeConverter
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.UsersItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun toListUsers(data: String): List<UsersItem> {
        val usersList = object : TypeToken<List<UsersItem>>() {}.type
        return Gson().fromJson(data, usersList)
    }

    @TypeConverter
    fun fromUsersList(list: List<UsersItem>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toListPosts(data: String): List<PostsItem> {
        val postsList = object : TypeToken<List<PostsItem>>() {}.type
        return Gson().fromJson(data, postsList)
    }

    @TypeConverter
    fun fromPostsList(list: List<PostsItem>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toPostByUserId(data: String): List<PostByUserIdItem> {
        val post = object : TypeToken<List<PostByUserIdItem>>() {}.type
        return Gson().fromJson(data, post)
    }

    @TypeConverter
    fun fromPostByUserId(post: List<PostByUserIdItem>): String {
        return Gson().toJson(post)
    }
}