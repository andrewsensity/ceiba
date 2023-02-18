package com.andres.ceiba.presentation.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen(route = "splash_screen")
    object MainScreen : Screen(route = "main_screen")
    object DetailScreen : Screen(route = "detail_screen")
}