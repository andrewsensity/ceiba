package com.andres.ceiba.data.repositories.local

import com.andres.ceiba.data.local.dao.CeibaDao
import com.andres.ceiba.data.mappers.*
import com.andres.ceiba.domain.model.posts.Posts
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.Users
import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.domain.repositories.local.CeibaRepositoryLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CeibaRepositoryLocalImpl(
    private val ceibaDao: CeibaDao
): CeibaRepositoryLocal {
    override suspend fun insertUsersDB(usersList: List<UsersItem>) {
        ceibaDao.insertUsersDB(usersList.toUsersEntity())
    }

    override suspend fun insertPostsDB(postsList: List<PostsItem>) {
        ceibaDao.insertPostsDB(postsList.toPostsEntity())
    }

    override fun getUsersFromDB(): Flow<List<UsersItem>> {
        return ceibaDao.getUsersFromDB().map { it.toUsersList() }
    }

    override fun getPostsFromDB(): Flow<List<PostsItem>> {
        return ceibaDao.getPostsFromDB().map { it.toPostsList() }
    }

    override fun getPostByUserIdFromDB(userId: Int): Flow<PostsItem> {
        return ceibaDao.getPostByUserIdFromDB().map { it.toPostItem() }
    }
}