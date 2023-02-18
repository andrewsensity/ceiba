package com.andres.ceiba.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.andres.ceiba.presentation.navigation.mainGraph
import com.andres.ceiba.presentation.navigation.splashGraph
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CeibaNavHost(
    navController: NavHostController = rememberAnimatedNavController(),
    startDestination: String = Screen.SplashScreen.route,
) {
    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        splashGraph(navController)
        mainGraph(navController)
    }
}