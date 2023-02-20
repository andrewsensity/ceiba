package com.andres.ceiba.data.repositories.local

import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.UsersItem

object DataSourceDao {

    val buildUserList = listOf(
        UsersItem(
            email = "andrewboy0411@hotmail.com",
            name = "Andres Echavarria",
            phone = "3504723977",
            id = 1
        )
    )
    val buildPostsList = listOf(
        PostsItem(
            body = "Comments",
            title = "Title",
            userId = 1,
            id = 0
        )
    )
    val buildPostsByUserIdList = listOf(
        PostByUserIdItem(
            body = "Comments",
            title = "Title",
            userId = 1,
            id = 0
        )
    )

}