package com.andres.ceiba.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres.ceiba.data.utils.Constants
import com.andres.ceiba.data.utils.Constants.USERS_NAV
import com.andres.ceiba.data.utils.Utils.toJson
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.domain.use_cases.CeibaUseCases
import com.andres.ceiba.presentation.navigation.Screen
import com.andres.ceiba.presentation.ui.UiEventCeiba
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
@OptIn(DelicateCoroutinesApi::class)
class SplashViewModel @Inject constructor(
    private val ceibaUseCases: CeibaUseCases,
) : ViewModel() {
    private var job: Job = Job()
    private val _uiEvent = Channel<UiEventCeiba>()
    val uiEvent = _uiEvent.receiveAsFlow()
    var usersDB = mutableStateListOf<UsersItem>()
        private set
    var postsDB = mutableStateListOf<PostsItem>()
        private set

    init {
        getUserDB()
        getPostDB()
        if (usersDB.isEmpty()) {
            getUser()
        }
    }

    private fun getUser() {
        viewModelScope.launch {
            ceibaUseCases.getUsersUseCase()
                .onSuccess { users ->
                    insertUsersDB(users)
                    getPosts()
                }.onFailure {
                    val errorCode = it.message ?: Constants.EMPTY
                    Log.e("error_category", errorCode)
                    return@onFailure
                }
        }
    }

    private fun getPosts() {
        viewModelScope.launch {
            ceibaUseCases.getPostsUseCase()
                .onSuccess { posts ->
                    insertPostsDB(posts)
                    delay(2000)
                    _uiEvent.send(
                        UiEventCeiba.Navigate(
                            Screen.MainScreen.route + "?$USERS_NAV=${usersDB.toJson()}"
                        )
                    )
                }.onFailure {
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

    private fun getUserDB() {
        ceibaUseCases.getUsersDBUseCase()
            .onEach { userItemList ->
                if (userItemList != null) {
                    usersDB.clear()
                    usersDB.addAll(userItemList)
                }
            }.launchIn(viewModelScope)
    }

    private fun getPostDB() {
        ceibaUseCases.getPostsDBUseCase().onEach { postItemsList ->
            if (postItemsList != null) {
                postsDB.clear()
                postsDB.addAll(postItemsList)
            }
        }.launchIn(viewModelScope)
    }

    private fun cancelJobIfRunning() {
        if (job.isActive) {
            job.cancel()
        }
    }
}