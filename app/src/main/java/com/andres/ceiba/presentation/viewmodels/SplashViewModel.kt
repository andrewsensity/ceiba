package com.andres.ceiba.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres.ceiba.data.utils.Constants
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.domain.use_cases.CeibaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
@OptIn(DelicateCoroutinesApi::class)
class SplashViewModel @Inject constructor(
    private val ceibaUseCases: CeibaUseCases,
) : ViewModel() {
    var isLoading by mutableStateOf(false)
    private var job: Job = Job()

    init {
        getUser()
        getPosts()
    }

    private fun getUser() {
        viewModelScope.launch {
            isLoading = true
            ceibaUseCases.getUsersUseCase()
                .onSuccess { users ->
                    isLoading = false
                    insertUsersDB(users)
                }.onFailure {
                    isLoading = false
                    val errorCode = it.message ?: Constants.EMPTY
                    Log.e("error_category", errorCode)
                    return@onFailure
                }
        }
    }

    private fun getPosts() {
        viewModelScope.launch {
            isLoading = true
            ceibaUseCases.getPostsUseCase()
                .onSuccess { posts ->
                    isLoading = false
                    insertPostsDB(posts)
                }.onFailure {
                    isLoading = false
                    val errorCode = it.message ?: Constants.EMPTY
                    Log.e("error_category", errorCode)
                    return@onFailure
                }
        }
    }

    private fun insertUsersDB(list: ArrayList<UsersItem>) {
        cancelJobIfRunning()
        job = GlobalScope.launch {
            ceibaUseCases.deleteUsersUseCase()
            ceibaUseCases.insertUsersDBUseCase(list)
        }
    }

    private fun insertPostsDB(list: ArrayList<PostsItem>) {
        cancelJobIfRunning()
        job = GlobalScope.launch {
            ceibaUseCases.deletePostsUseCase()
            ceibaUseCases.insertPostsDBUseCase(list)
        }
    }

    private fun cancelJobIfRunning() {
        if (job.isActive) {
            job.cancel()
        }
    }
}