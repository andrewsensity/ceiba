package com.andres.ceiba.presentation.ui.splash.pages

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.andres.ceiba.presentation.navigation.Screen
import com.andres.ceiba.presentation.theme.GreenCeiba
import com.andres.ceiba.presentation.viewmodels.SplashViewModel
import com.andres.ceiba.presentation.ui.splash.molecules.ContentSplash
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel = hiltViewModel(),
) {
    val scale = remember { androidx.compose.animation.core.Animatable(0f) }
    val time by remember { mutableStateOf(1000) }
    val destination = Screen.MainScreen.route
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = time,
            )
        )
        delay(time.toLong())
        navController.navigate(destination) {
            popUpTo(Screen.SplashScreen.route) { inclusive = true }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenCeiba),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        ContentSplash(scale = scale)
    }
}