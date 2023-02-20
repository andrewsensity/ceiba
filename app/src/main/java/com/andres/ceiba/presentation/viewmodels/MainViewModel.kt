package com.andres.ceiba.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres.ceiba.data.utils.MainEvents
import com.andres.ceiba.data.utils.Constants.EMPTY
import com.andres.ceiba.data.utils.Constants.USERS_ITEM
import com.andres.ceiba.data.utils.toJson
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
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
class MainViewModel @Inject constructor(
    private val ceibaUseCases: CeibaUseCases,
) : ViewModel() {

    var isLoading by mutableStateOf(false)
    var usersDB = mutableStateListOf<UsersItem>()
        private set
    var postsDB = mutableStateListOf<PostsItem>()
        private set
    private val _uiEvent = Channel<UiEventCeiba>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        getUserDB()
        getPostDB()
    }

    fun onEvent(event: MainEvents) {
        when (event) {
            is MainEvents.OnClickPostsByUserId -> {
                getPostsByUserId(event.id)
            }
        }
    }

    private fun getPostsByUserId(userId: Int) {
        viewModelScope.launch {
            isLoading = true
            ceibaUseCases.getPostsByUserIdUseCase(userId + 1)
                .onSuccess { postByUserId ->
                    isLoading = false
                    insertPostsByUserIdDB(postByUserId)
                    _uiEvent.send(
                        UiEventCeiba.Navigate(
                            "${Screen.PostsScreen.route}?$USERS_ITEM=${usersDB[userId].toJson()}"
                        )
                    )
                }.onFailure {
                    isLoading = false
                    val errorCode = it.message ?: EMPTY
                    Log.e("error_category", errorCode)
                    return@onFailure
                }
        }
    }

    private fun insertPostsByUserIdDB(list: List<PostByUserIdItem>) {
        viewModelScope.launch {
            ceibaUseCases.deletePostsByUserIdUseCase()
            ceibaUseCases.insertPostByUserIdDBUseCase(list)
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
}