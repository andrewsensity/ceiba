package com.andres.ceiba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.andres.ceiba.presentation.theme.CeibaTheme
import com.andres.ceiba.presentation.ui.main.MainScreen
import com.andres.ceiba.presentation.viewmodels.CeibaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CeibaTheme {
                MainScreen()
            }
        }
    }
}