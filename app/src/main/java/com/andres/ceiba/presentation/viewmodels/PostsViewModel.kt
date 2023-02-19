package com.andres.ceiba.presentation.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres.ceiba.data.utils.MainEvents
import com.andres.ceiba.data.utils.PostsEvents
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.use_cases.CeibaUseCases
import com.andres.ceiba.presentation.ui.UiEventCeiba
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val ceibaUseCases: CeibaUseCases,
) : ViewModel() {

    var isLoading by mutableStateOf(false)
    var postByUserIdDB = mutableStateListOf<PostByUserIdItem>()
        private set

    fun onEvent(event: PostsEvents) {
        when (event) {
            is PostsEvents.GetPostsByUserId -> {
                getPostByUserIdDB(event.id)
            }
        }
    }

    private fun getPostByUserIdDB(id: Int) {
        isLoading = true
        ceibaUseCases.getPostByUserIdDBUseCase(id)
            .onEach { postByUserIdItemsList ->
                isLoading = false
                postByUserIdItemsList?.let { postByUserIdItemList ->
                    postByUserIdDB.addAll(postByUserIdItemList)
                }
            }.launchIn(viewModelScope)
    }
}