package com.andres.ceiba.presentation.navigation

import com.andres.ceiba.data.utils.Constants.MAIN_SCREEN
import com.andres.ceiba.data.utils.Constants.POSTS_SCREEN
import com.andres.ceiba.data.utils.Constants.SPLASH_SCREEN

sealed class Screen(val route: String) {
    object SplashScreen : Screen(route = SPLASH_SCREEN)
    object MainScreen : Screen(route = MAIN_SCREEN)
    object PostsScreen : Screen(route = POSTS_SCREEN)
}