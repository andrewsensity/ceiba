package com.andres.ceiba.data.repositories.local

import com.andres.ceiba.data.local.dao.CeibaDao
import com.andres.ceiba.data.mappers.*
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserId
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.model.posts.PostsItem
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

    override suspend fun insertPostsByUserId(postsByUserIdList: List<PostByUserIdItem>) {
        ceibaDao.insertPostsByUserIdDB(postsByUserIdList.toPostByUserIdEntity())
    }

    override fun getUsersFromDB(): Flow<List<UsersItem>?> {
        return ceibaDao.getUsersFromDB().map { usersEntity ->
            usersEntity?.toUsersList()
        }
    }

    override fun getPostsFromDB(): Flow<List<PostsItem>?> {
        return ceibaDao.getPostsFromDB().map { postsEntity ->
            postsEntity?.toPostsList()
        }
    }

    override fun getPostByUserIdFromDB(userId: Int): Flow<List<PostByUserIdItem>?> {
        return ceibaDao.getPostByUserIdFromDB(userId).map { postByUserIdEntity ->
            postByUserIdEntity?.toPostByUserIdList()
        }
    }

    override suspend fun deleteUsers() {
        ceibaDao.deleteUsers()
    }

    override suspend fun deletePosts() {
        ceibaDao.deletePosts()
    }

    override suspend fun deletePostsByUserId() {
        ceibaDao.deletePostsByUserId()
    }
}