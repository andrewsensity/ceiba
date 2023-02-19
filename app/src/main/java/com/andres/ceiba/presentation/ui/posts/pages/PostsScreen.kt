package com.andres.ceiba.presentation.ui.posts.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.andres.ceiba.domain.model.posts.PostsItem
import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.presentation.theme.GreenCeiba
import com.andres.ceiba.presentation.ui.posts.molecules.FooterPost
import com.andres.ceiba.presentation.ui.posts.molecules.HeaderPost
import com.andres.ceiba.presentation.ui.posts.molecules.TopAppBarPosts

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostsScreen(
    posts: PostsItem,
    user: UsersItem,
    navController: NavController,
) {
    Scaffold(
        topBar = {
            TopAppBarPosts(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(GreenCeiba.copy(alpha = 0.5f))
        ) {
            HeaderPost(user = user)
            FooterPost(posts = posts)
        }
    }
}