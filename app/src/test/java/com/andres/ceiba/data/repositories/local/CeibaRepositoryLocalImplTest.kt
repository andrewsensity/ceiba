package com.andres.ceiba.data.repositories.local

import com.andres.ceiba.data.local.dao.CeibaDao
import com.andres.ceiba.data.local.entity.PostByUserIdEntity
import com.andres.ceiba.data.local.entity.PostsEntity
import com.andres.ceiba.data.local.entity.UsersEntity
import com.andres.ceiba.data.repositories.local.DataSourceDao.buildPostsByUserIdList
import com.andres.ceiba.data.repositories.local.DataSourceDao.buildPostsList
import com.andres.ceiba.data.repositories.local.DataSourceDao.buildUserList
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.UsersItem
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CeibaRepositoryLocalImplTest {
    private lateinit var ceibaDao: CeibaDao
    private lateinit var ceibaRepositoryLocalImpl: CeibaRepositoryLocalImpl

    @Before
    fun setUp() {
        ceibaDao = mockk(relaxed = true)
        ceibaRepositoryLocalImpl = CeibaRepositoryLocalImpl(ceibaDao)
    }

    @Test
    fun `Verify user was insert in database`() = runTest {
        val user = buildUserList
        val captor = slot<UsersEntity>()
        ceibaRepositoryLocalImpl.insertUsersDB(usersList = user)
        coVerify { ceibaDao.insertUsersDB(capture(captor)) }
        Assert.assertEquals(user[0].email, captor.captured.users[0].email)
    }

    @Test
    fun `Verify post was insert in database`() = runTest {
        val posts = buildPostsList
        val captor = slot<PostsEntity>()
        ceibaRepositoryLocalImpl.insertPostsDB(postsList = posts)
        coVerify { ceibaDao.insertPostsDB(capture(captor)) }
        Assert.assertEquals(posts[0].id, captor.captured.id)
    }

    @Test
    fun `Verify post was insert by user id in database`() = runTest {
        val postsByUserId = buildPostsByUserIdList
        val captor = slot<PostByUserIdEntity>()
        ceibaRepositoryLocalImpl.insertPostsByUserId(postsByUserIdList = postsByUserId)
        coVerify { ceibaDao.insertPostsByUserIdDB(capture(captor)) }
        Assert.assertEquals(postsByUserId[0].id, captor.captured.id)
    }

    @Test
    fun `Verify if delete post by user id from database`() = runTest {
        ceibaRepositoryLocalImpl.deletePostsByUserId()
        coVerify { ceibaDao.deletePostsByUserId() }
    }

    @Test
    fun `Verify if delete posts from database`() = runTest {
        ceibaRepositoryLocalImpl.deletePosts()
        coVerify { ceibaDao.deletePosts() }
    }

    @Test
    fun `Verify if delete users from database`() = runTest {
        ceibaRepositoryLocalImpl.deleteUsers()
        coVerify { ceibaDao.deleteUsers() }
    }

    @Test
    fun `Verify correct user is retrieved`() = runTest {
        val itemList = listOf(UsersItem())
        coEvery { ceibaDao.getUsersFromDB() } returns flow { UsersEntity(users = buildUserList) }
        val user = ceibaRepositoryLocalImpl.getUsersFromDB()
        user.collect { usersItemList ->
            Assert.assertEquals(itemList, usersItemList)
        }
    }

    @Test
    fun `Verify correct post is retrieved`() = runTest {
        val postsItemList = listOf(PostsItem())
        coEvery { ceibaDao.getPostsFromDB() } returns flow { PostsEntity(posts = buildPostsList) }
        val user = ceibaRepositoryLocalImpl.getPostsFromDB()
        user.collect { postsItems ->
            Assert.assertEquals(postsItemList, postsItems)
        }
    }

    @Test
    fun `Verify correct post by user id is retrieved`() = runTest {
        val postByUserIdItemList =
            listOf(PostByUserIdItem(body = "", id = 1, title = "", userId = 0))
        coEvery { ceibaDao.getUsersFromDB() } returns flow {
            PostByUserIdEntity(postByUserId = buildPostsByUserIdList)
        }
        val user = ceibaRepositoryLocalImpl.getPostByUserIdFromDB()
        user.collect { postByUserIdItems ->
            Assert.assertEquals(postByUserIdItemList, postByUserIdItems)
        }
    }
}