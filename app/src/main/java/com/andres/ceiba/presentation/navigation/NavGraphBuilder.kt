package com.andres.ceiba.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.andres.ceiba.data.utils.Constants.USERS_ITEM
import com.andres.ceiba.data.utils.Constants.USERS_NAV
import com.andres.ceiba.data.utils.Utils.fromJson
import com.andres.ceiba.domain.model.users.Users
import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.presentation.ui.main.pages.MainScreen
import com.andres.ceiba.presentation.ui.posts.pages.PostsScreen
import com.andres.ceiba.presentation.ui.splash.pages.SplashScreen
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashGraph(navController: NavController) {
    composable(Screen.SplashScreen.route) {
        SplashScreen(navController = navController)
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mainGraph(navController: NavController) {
    composable(
        route = "${Screen.MainScreen.route}?$USERS_NAV={$USERS_NAV}",
        enterTransition = {
            slideInVertically(initialOffsetY = { 4000 })
        },
        exitTransition = {
            slideOutVertically(targetOffsetY = { 2000 })
        }
    ) { navBackStackEntry ->
        val user =
            navBackStackEntry.arguments?.getString(USERS_NAV)?.fromJson(Users::class.java)
                ?: Users()
        MainScreen(navController = navController, user = user)
    }
    composable(
        route = "${Screen.PostsScreen.route}?$USERS_ITEM={$USERS_ITEM}",
        enterTransition = {
            slideInVertically(initialOffsetY = { 4000 })
        },
        exitTransition = {
            slideOutVertically(targetOffsetY = { 2000 })
        }
    ) { navBackStackEntry ->
        val userItem =
            navBackStackEntry.arguments?.getString(USERS_ITEM)?.fromJson(UsersItem::class.java)
                ?: UsersItem()
        PostsScreen(user = userItem, navController = navController)
    }
}