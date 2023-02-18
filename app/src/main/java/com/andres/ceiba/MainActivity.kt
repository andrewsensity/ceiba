package com.andres.ceiba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.andres.ceiba.presentation.navigation.CeibaNavHost
import com.andres.ceiba.presentation.theme.CeibaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CeibaTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    CeibaNavHost()
                }
            }
        }
    }
}