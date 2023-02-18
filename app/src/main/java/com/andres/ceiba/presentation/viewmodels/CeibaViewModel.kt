package com.andres.ceiba.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres.ceiba.domain.use_cases.CeibaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CeibaViewModel @Inject constructor(
    private val ceibaUseCases: CeibaUseCases,
) : ViewModel() {

    var isLoading by mutableStateOf(false)

    init {
        getUser()
        getPosts()
        getPostsByUserId(1)
    }

    fun getUser() {
        viewModelScope.launch {
            isLoading = true
            ceibaUseCases.usersUseCase()
                .onSuccess { users ->
                    isLoading = false
                    users
                }.onFailure {
                    isLoading = false
                    val errorCode = it.message
                }
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            isLoading = true
            ceibaUseCases.postsUseCase()
                .onSuccess {posts ->
                    isLoading = false
                    posts
                }.onFailure {
                    isLoading = false
                    val errorCode = it.message
                }
        }
    }

    fun getPostsByUserId(userId: Int) {
        viewModelScope.launch {
            isLoading = true
            ceibaUseCases.postsByUserIdUseCase(userId)
                .onSuccess { postsItem ->
                    isLoading = false
                    postsItem
                }.onFailure {
                    isLoading = false
                    val errorCode = it.message
                }
        }
    }
}