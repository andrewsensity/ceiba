package com.andres.ceiba.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres.ceiba.data.utils.CeibaEvents
import com.andres.ceiba.data.utils.Constants.POSTS_ITEM
import com.andres.ceiba.data.utils.Constants.USERS_ITEM
import com.andres.ceiba.data.utils.toJson
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.domain.use_cases.CeibaUseCases
import com.andres.ceiba.presentation.navigation.Screen
import com.andres.ceiba.presentation.ui.UiEventCeiba
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CeibaViewModel @Inject constructor(
    private val ceibaUseCases: CeibaUseCases,
) : ViewModel() {

    var isLoading by mutableStateOf(false)
    var usersDB = mutableStateListOf<UsersItem>()
        private set
    var postByIdDB by mutableStateOf(PostsItem())
        private set
    var postsDB = mutableStateListOf<PostsItem>()
        private set
    var postsItemDB by mutableStateOf(PostsItem())
        private set
    private val _uiEvent = Channel<UiEventCeiba>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        getUser()
        getPosts()
        getUserDB()
        getPostDB()
    }

    fun onEvent(event: CeibaEvents) {
        when (event) {
            is CeibaEvents.OnClickPostsByUserId -> {
                getPostByUserIdDB(event.id)
            }
        }
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

    fun getUserDB() {
        viewModelScope.launch {
            ceibaUseCases.getUsersDBUseCase()
                .onEach { userItemList ->
                    usersDB.addAll(userItemList)
                }.launchIn(viewModelScope)
        }
    }

    fun getPostDB() {
        viewModelScope.launch {
            ceibaUseCases.getPostsDBUseCase().onEach { postItemsList ->
                postsDB.addAll(postItemsList)
            }.launchIn(viewModelScope)
        }
    }

    private fun getPostByUserIdDB(id: Int) {
        viewModelScope.launch {
            ceibaUseCases.getPostsByUserIdUseCase(id)
                .onSuccess { postsItem ->
                    postsItemDB = postsItem
                    _uiEvent.send(
                        UiEventCeiba.Navigate(
                            Screen.PostsScreen.route +
                                    "?$POSTS_ITEM=${postsItem.toJson()}&$USERS_ITEM=${usersDB[id].toJson()}"
                        )
                    )
                }.onFailure {
                    val errorCode = it.message
                }
        }
    }

    private fun getUser() {
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

    private fun getPosts() {
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
                    postByIdDB = postsItem
                }.onFailure {
                    isLoading = false
                    val errorCode = it.message
                }
        }
    }
}