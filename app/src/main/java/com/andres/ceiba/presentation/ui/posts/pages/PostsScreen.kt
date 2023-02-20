package com.andres.ceiba.presentation.ui.posts.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.presentation.ui.posts.molecules.FooterPost
import com.andres.ceiba.presentation.ui.posts.molecules.HeaderPost
import com.andres.ceiba.presentation.ui.posts.molecules.TopAppBarPosts
import com.andres.ceiba.presentation.viewmodels.PostsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(
    user: UsersItem,
    navController: NavController,
    postsViewModel: PostsViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            TopAppBarPosts(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
        ) {
            HeaderPost(user = user)
            FooterPost(
                postsViewModel = postsViewModel,
            )
        }
    }
}