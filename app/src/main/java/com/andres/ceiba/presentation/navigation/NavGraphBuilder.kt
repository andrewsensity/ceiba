package com.andres.ceiba.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.andres.ceiba.presentation.ui.main.MainScreen
import com.andres.ceiba.presentation.ui.splash.SplashScreen
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.splashGraph(navController: NavController) {
    composable(Screen.SplashScreen.route) {
        SplashScreen(navController = navController)
    }
}

@OptIn(ExperimentalAnimationApi::class)
fun NavGraphBuilder.mainGraph(navController: NavController) {
    composable(route = Screen.MainScreen.route) {
        MainScreen(navController = navController)
    }
    /*composable(
        route = "${Screen.DetailScreen.route}?$ID_PARAMETER={$ID_PARAMETER}",
        arguments = listOf(navArgument(ID_PARAMETER) { type = NavType.IntType }),
        enterTransition = {
            slideInVertically(initialOffsetY = { 4000 })
        },
        exitTransition = {
            slideOutVertically(targetOffsetY = { 2000 })
        }
    ) { navBackStackEntry ->
        navBackStackEntry.arguments?.let { bundle ->
            val id = bundle.getInt(ID_PARAMETER)
            DetailScreen(id = id, navController = navController)
        }
    }*/
}