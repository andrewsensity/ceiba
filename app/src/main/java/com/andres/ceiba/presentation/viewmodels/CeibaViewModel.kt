package com.andres.ceiba.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.domain.use_cases.CeibaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CeibaViewModel @Inject constructor(
    private val ceibaUseCases: CeibaUseCases,
) : ViewModel() {

    var isLoading by mutableStateOf(false)
    private var job: Job = Job()

    init {
        getUser()
        getPosts()
        getPostsByUserId(1)
    }

    fun insertUsers(list: ArrayList<UsersItem>) {
        viewModelScope.launch {
            ceibaUseCases.insertUsersDBUseCase(list)
        }
    }

    fun insertPosts(list: ArrayList<PostsItem>) {
        viewModelScope.launch {
            ceibaUseCases.insertPostsDBUseCase(list)
        }
    }

    fun getUser() {
        viewModelScope.launch {
            isLoading = true
            ceibaUseCases.getUsersUseCase()
                .onSuccess { users ->
                    isLoading = false
                    insertUsers(users)
                }.onFailure {
                    isLoading = false
                    val errorCode = it.message
                }
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            isLoading = true
            ceibaUseCases.getPostsUseCase()
                .onSuccess { posts ->
                    isLoading = false
                    insertPosts(posts)
                }.onFailure {
                    isLoading = false
                    val errorCode = it.message
                }
        }
    }

    fun getPostsByUserId(userId: Int) {
        viewModelScope.launch {
            isLoading = true
            ceibaUseCases.getPostsByUserIdUseCase(userId)
                .onSuccess { postsItem ->
                    isLoading = false
                }.onFailure {
                    isLoading = false
                    val errorCode = it.message
                }
        }
    }
}