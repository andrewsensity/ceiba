package com.andres.ceiba.presentation.ui.main.molecules

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.andres.ceiba.R
import com.andres.ceiba.presentation.theme.GreenCeiba

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarMain() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.enterTest),
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = GreenCeiba,
            titleContentColor = Color.White
        )
    )
}