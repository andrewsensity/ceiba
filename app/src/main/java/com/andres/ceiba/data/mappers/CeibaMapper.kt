package com.andres.ceiba.data.mappers

import com.andres.ceiba.data.local.entity.PostByUserIdEntity
import com.andres.ceiba.data.local.entity.PostsEntity
import com.andres.ceiba.data.local.entity.UsersEntity
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.model.posts.PostsItem
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

fun List<PostByUserIdItem>.toPostByUserIdEntity(): PostByUserIdEntity {
    return PostByUserIdEntity(
        postByUserId = this
    )
}

fun PostByUserIdEntity.toPostByUserIdList(): List<PostByUserIdItem>? {
    return this.postByUserId
}