package com.andres.ceiba.presentation.ui.main.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.andres.ceiba.presentation.ui.main.atoms.CustomLoading
import com.andres.ceiba.presentation.ui.main.molecules.TopAppBarMain
import com.andres.ceiba.presentation.ui.main.organisms.ContentMain
import com.andres.ceiba.presentation.viewmodels.CeibaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    ceibaViewModel: CeibaViewModel = hiltViewModel(),
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBarMain()
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            ContentMain(
                navController = navController,
                ceibaViewModel = ceibaViewModel
            )
        }
        CustomLoading(
            context = context,
            showProgress = ceibaViewModel.isLoading
        )
    }
}