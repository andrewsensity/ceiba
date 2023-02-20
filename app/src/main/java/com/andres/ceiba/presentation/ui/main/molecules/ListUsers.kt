package com.andres.ceiba.presentation.ui.main.molecules

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.andres.ceiba.R
import com.andres.ceiba.data.utils.Utils.filterList
import com.andres.ceiba.domain.model.users.Users
import com.andres.ceiba.presentation.theme.GreenCeiba
import com.andres.ceiba.presentation.viewmodels.MainViewModel

@Composable
fun ListUsers(
    mainViewModel: MainViewModel,
    navController: NavController,
    searchUser: String,
    user: Users,
) {
    val lazyListState = rememberLazyListState()
    val userListFiltered = user.filterList(searchUser.lowercase()) { usersItem ->
        usersItem.name.lowercase().contains(searchUser)
    }
    LazyColumn(state = lazyListState) {
        if (userListFiltered.isNotEmpty()) {
            itemsIndexed(userListFiltered) { index, users ->
                CardInformation(
                    index = index,
                    usersItem = users,
                    navController = navController,
                    mainViewModel = mainViewModel
                )
            }
        } else {
            item {
                AnimatedVisibility(visible = true, enter = slideInVertically()) {
                    Card(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .background(
                                GreenCeiba.copy(alpha = 0.5f),
                                RoundedCornerShape(15.dp)
                            )
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            text = stringResource(R.string.list_is_empty),
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = GreenCeiba,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            }
        }
    }
}