package com.andres.ceiba.presentation.ui.splash.pages

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.andres.ceiba.presentation.navigation.Screen
import com.andres.ceiba.presentation.theme.GreenCeiba
import com.andres.ceiba.presentation.ui.UiEventCeiba
import com.andres.ceiba.presentation.ui.splash.molecules.ContentSplash
import com.andres.ceiba.presentation.viewmodels.SplashViewModel
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel = hiltViewModel(),
) {
    val scale = remember { androidx.compose.animation.core.Animatable(0f) }
    val time by remember { mutableStateOf(3000) }
    val scope = rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = time,
            )
        )
        scope.launch {
            splashViewModel.uiEvent.collect { uiEvent ->
                when (uiEvent) {
                    is UiEventCeiba.Navigate -> navController.navigate(uiEvent.screen) {
                        popUpTo(Screen.SplashScreen.route) { inclusive = true }
                    }
                }
            }
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