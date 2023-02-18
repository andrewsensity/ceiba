package com.andres.ceiba.presentation.ui.main.pages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.andres.ceiba.R
import com.andres.ceiba.data.utils.Constants.EMPTY
import com.andres.ceiba.presentation.theme.GreenCeiba
import com.andres.ceiba.presentation.ui.main.atoms.CustomTextField
import com.andres.ceiba.presentation.ui.main.molecules.CardInformation
import com.andres.ceiba.presentation.ui.util.filterList
import com.andres.ceiba.presentation.viewmodels.CeibaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    ceibaViewModel: CeibaViewModel = hiltViewModel(),
) {
    val usersList = ceibaViewModel.usersDB
    val postList = ceibaViewModel.postsDB
    var showPosts by remember { mutableStateOf(false) }
    val lazyListState = rememberLazyListState()
    val scope = rememberCoroutineScope()
    val localFocusManager = LocalFocusManager.current
    val focusRequester = remember { FocusRequester() }
    var searchVisibility by remember { mutableStateOf(false) }
    var searchUser by rememberSaveable { mutableStateOf("") }
    val userListFiltered = usersList.filterList(searchUser.lowercase()) { usersItem ->
        usersItem.name.lowercase().contains(searchUser)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Prueba de Ingreso",
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
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            CustomTextField(
                value = searchUser,
                onValueChange = { user ->
                    searchUser = user
                    searchVisibility = false
                },
                label = stringResource(R.string.txt_description_search),
                modifier = Modifier
                    .focusRequester(focusRequester)
                    .onFocusChanged { searchVisibility = !it.isFocused },
                trailingIcon = {
                    Icon(
                        imageVector = if(searchUser.isNotEmpty()) Icons.Default.Close else Icons.Default.Search,
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
            LazyColumn(state = lazyListState) {
                itemsIndexed(userListFiltered) { index, users ->
                    CardInformation(
                        modifier = Modifier.padding(top = 16.dp),
                        usersItem = users,
                        posts = postList,
                        showPosts = showPosts,
                        showPostsOnChange = { show -> showPosts = show },
                        index = index
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreenPrev() {

}