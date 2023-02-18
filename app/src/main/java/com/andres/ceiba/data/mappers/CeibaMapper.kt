package com.andres.ceiba.data.mappers

import com.andres.ceiba.data.local.entity.PostByUserIdEntity
import com.andres.ceiba.data.local.entity.PostsEntity
import com.andres.ceiba.data.local.entity.UsersEntity
import com.andres.ceiba.domain.model.posts.Posts
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.Users
import com.andres.ceiba.domain.model.users.UsersItem

fun List<UsersItem>.toUsersEntity(): UsersEntity {
    return UsersEntity(
        users = this
    )
}

fun UsersEntity.toUsersList(): List<UsersItem> {
    return this.users
}

fun List<PostsItem>.toPostsEntity(): PostsEntity {
    return PostsEntity(
        posts = this
    )
}

fun PostsEntity.toPostsList(): List<PostsItem> {
    return this.posts
}

fun PostsItem.toPostByUserIdEntity(): PostByUserIdEntity {
    return PostByUserIdEntity(
        id = this.id,
        body = this.body,
        title = this.title,
        userId = this.userId
    )
}

fun PostByUserIdEntity.toPostItem(): PostsItem {
    return PostsItem(
        id = this.id,
        body = this.body,
        title = this.title,
        userId = this.userId
    )
}