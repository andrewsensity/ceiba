package com.andres.ceiba.presentation.ui.main.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.andres.ceiba.R
import com.andres.ceiba.data.utils.CeibaEvents
import com.andres.ceiba.domain.model.users.Address
import com.andres.ceiba.domain.model.users.Company
import com.andres.ceiba.domain.model.users.Geo
import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.presentation.theme.GreenCeiba
import com.andres.ceiba.presentation.ui.UiEventCeiba
import com.andres.ceiba.presentation.viewmodels.CeibaViewModel

@Composable
fun CardInformation(
    modifier: Modifier = Modifier,
    index: Int,
    usersItem: UsersItem,
    navController: NavController,
    ceibaViewModel: CeibaViewModel,
) {
    LaunchedEffect(key1 = true) {
        ceibaViewModel.uiEvent.collect { event ->
            when (event) {
                is UiEventCeiba.Navigate -> navController.navigate(event.screen)
            }
        }
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(20.dp))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                modifier = Modifier.padding(bottom = 8.dp),
                text = usersItem.name,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = GreenCeiba,
                    fontWeight = FontWeight.Bold
                )
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = stringResource(R.string.phone),
                    tint = GreenCeiba
                )
                Text(text = usersItem.phone)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = stringResource(R.string.email),
                    tint = GreenCeiba
                )
                Text(text = usersItem.email)
            }
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .clickable {
                        ceibaViewModel.onEvent(
                            CeibaEvents.OnClickPostsByUserId(id = index)
                        )
                    },
                text = stringResource(R.string.show_posts),
                style = MaterialTheme.typography.bodyMedium.copy(
                    textAlign = TextAlign.End,
                    color = GreenCeiba,
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

@Preview
@Composable
fun CardInformationPreview() {
    CardInformation(
        usersItem = UsersItem(
            address = Address(
                city = "Medellin",
                geo = Geo(lat = "100", lng = "200"),
                street = "Calle bermont",
                suite = "",
                zipcode = ""
            ),
            company = Company(
                bs = "",
                catchPhrase = "",
                name = ""
            ),
            email = "andrewboy0411@me.com",
            id = 1,
            name = "Andres Echavarria",
            phone = "3504723977",
            username = "Andrewboy0411",
            website = "www.andrew.com"
        ),
        navController = rememberNavController(),
        ceibaViewModel = hiltViewModel(),
        index = 0
    )
}