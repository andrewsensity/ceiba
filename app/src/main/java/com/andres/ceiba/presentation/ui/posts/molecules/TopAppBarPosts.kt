package com.andres.ceiba.presentation.ui.posts.molecules

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.andres.ceiba.R
import com.andres.ceiba.presentation.theme.GreenCeiba

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPosts(
    navController: NavController
) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.posts),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = GreenCeiba,
            titleContentColor = Color.White
        ),
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.arrow_back),
                    tint = Color.White
                )
            }
        }
    )
}