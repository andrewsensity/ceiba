package com.andres.ceiba.presentation.ui.posts.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.andres.ceiba.R
import com.andres.ceiba.presentation.theme.GreenCeiba
import com.andres.ceiba.presentation.viewmodels.PostsViewModel
import java.util.*

@Composable
fun FooterPost(
    postsViewModel: PostsViewModel,
) {
    Card(
        modifier = Modifier.fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = GreenCeiba.copy(alpha = 0.2f)
        ),
        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, bottom = 8.dp),
            text = stringResource(R.string.posts),
            style = MaterialTheme.typography.bodyLarge.copy(
                color = GreenCeiba,
                fontWeight = FontWeight.Bold
            )
        )
        LazyColumn {
            itemsIndexed(postsViewModel.postByUserIdDB) { index, postByUserIdItem ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp, bottom = 8.dp),
                    text = postByUserIdItem.title.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.getDefault()
                        ) else it.toString()
                    },
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    text = postByUserIdItem.body.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.getDefault()
                        ) else it.toString()
                    },
                    style = MaterialTheme.typography.bodyMedium
                )
                if (postsViewModel.postByUserIdDB.size - 1 != index) {
                    Divider(modifier = Modifier.padding(horizontal = 30.dp, vertical = 8.dp))
                } else {
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}