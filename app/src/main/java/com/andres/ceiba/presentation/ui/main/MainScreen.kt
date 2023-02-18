package com.andres.ceiba.presentation.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.andres.ceiba.presentation.viewmodels.CeibaViewModel

@Composable
fun MainScreen(
    ceibaViewModel: CeibaViewModel = hiltViewModel()
) {
    /*LaunchedEffect(key1 = true) {
        ceibaViewModel.getPosts()
        ceibaViewModel.getPostsByUserId(1)
        ceibaViewModel.getUser()
    }*/
}

@Preview
@Composable
fun MainScreenPrev() {

}