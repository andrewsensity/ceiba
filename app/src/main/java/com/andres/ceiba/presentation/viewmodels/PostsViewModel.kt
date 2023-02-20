package com.andres.ceiba.presentation.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.domain.use_cases.CeibaUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val ceibaUseCases: CeibaUseCases,
) : ViewModel() {

    var postByUserIdDB = mutableStateListOf<PostByUserIdItem>()
        private set

    init {
        getPostByUserIdDB()
    }

    private fun getPostByUserIdDB() {
        ceibaUseCases.getPostByUserIdDBUseCase()
            .onEach { postByUserIdItemsList ->
                if (postByUserIdItemsList != null) {
                    postByUserIdDB.clear()
                    postByUserIdDB.addAll(postByUserIdItemsList)
                }
            }.launchIn(viewModelScope)
    }
}