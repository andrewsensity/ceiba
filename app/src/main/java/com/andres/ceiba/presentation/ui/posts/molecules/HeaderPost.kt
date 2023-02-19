package com.andres.ceiba.presentation.ui.posts.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.andres.ceiba.R
import com.andres.ceiba.domain.model.users.UsersItem
import com.andres.ceiba.presentation.theme.GreenCeiba

@Composable
fun HeaderPost(
    user: UsersItem,
) {
    Text(
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, bottom = 8.dp),
        text = user.name,
        style = MaterialTheme.typography.bodyLarge.copy(
            color = GreenCeiba,
            fontWeight = FontWeight.Bold
        )
    )
    Row(
        modifier = Modifier.padding(start = 30.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Phone,
            contentDescription = stringResource(R.string.phone),
            tint = GreenCeiba
        )
        Text(text = user.phone)
    }
    Row(
        modifier = Modifier.padding(start = 30.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Email,
            contentDescription = stringResource(R.string.email),
            tint = GreenCeiba
        )
        Text(text = user.email)
    }
}