package com.andres.ceiba.presentation.ui.main.organisms

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andres.ceiba.R
import com.andres.ceiba.data.utils.Constants.EMPTY
import com.andres.ceiba.domain.model.users.Users
import com.andres.ceiba.presentation.theme.GreenCeiba
import com.andres.ceiba.presentation.ui.main.atoms.CustomTextField
import com.andres.ceiba.presentation.ui.main.molecules.ListUsers
import com.andres.ceiba.presentation.viewmodels.MainViewModel

@Composable
fun ContentMain(
    mainViewModel: MainViewModel,
    navController: NavController,
    modifier: Modifier,
    user: Users,
) {
    val localFocusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    var searchVisibility by remember { mutableStateOf(false) }
    var searchUser by rememberSaveable { mutableStateOf(EMPTY) }
    Column(modifier = modifier) {
        CustomTextField(
            value = searchUser,
            onValueChange = { user ->
                searchUser = user
                searchVisibility = false
            },
            label = stringResource(R.string.txt_description_search),
            modifier = Modifier
                .focusRequester(focusRequester)
                .onFocusChanged { visibility -> searchVisibility = !visibility.isFocused },
            trailingIcon = {
                Icon(
                    imageVector = if (searchUser.isNotEmpty())
                        Icons.Default.Close else Icons.Default.Search,
                    contentDescription = stringResource(R.string.search),
                    modifier = Modifier.clickable {
                        searchUser = EMPTY
                        searchVisibility = true
                        localFocusManager.clearFocus()
                    },
                    tint = GreenCeiba
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        ListUsers(
            mainViewModel = mainViewModel,
            navController = navController,
            searchUser = searchUser,
            user = user
        )
    }
}