package com.andres.ceiba.presentation.ui.main.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.andres.ceiba.domain.model.users.Users
import com.andres.ceiba.presentation.ui.main.atoms.CustomLoading
import com.andres.ceiba.presentation.ui.main.molecules.TopAppBarMain
import com.andres.ceiba.presentation.ui.main.organisms.ContentMain
import com.andres.ceiba.presentation.viewmodels.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    mainViewModel: MainViewModel = hiltViewModel(),
    user: Users,
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBarMain()
        }
    ) { paddingValues ->
        ContentMain(
            modifier = Modifier
                .padding(paddingValues)
                .padding(top = 10.dp, start = 16.dp, end = 16.dp),
            navController = navController,
            mainViewModel = mainViewModel,
            user = user
        )
        CustomLoading(
            context = context,
            showProgress = mainViewModel.isLoading
        )
    }
}