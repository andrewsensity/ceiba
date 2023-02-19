package com.andres.ceiba.presentation.ui.posts.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.andres.ceiba.R
import com.andres.ceiba.data.utils.Constants.EMPTY
import com.andres.ceiba.data.utils.PostsEvents
import com.andres.ceiba.domain.model.post_by_user_id.PostByUserIdItem
import com.andres.ceiba.presentation.theme.GreenCeiba
import com.andres.ceiba.presentation.viewmodels.PostsViewModel

@Composable
fun FooterPost(
    postsViewModel: PostsViewModel,
) {
    var postByUserIdList: List<PostByUserIdItem> = emptyList()
    LaunchedEffect(key1 = true) {
        postByUserIdList = postsViewModel.postByUserIdDB
    }
    LazyColumn {
        items(postByUserIdList) { postByUserIdItem ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.White,
                        RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
                    )
            ) {
                Divider()
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, bottom = 8.dp),
                    text = stringResource(R.string.posts).uppercase(),
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = GreenCeiba,
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    text = postByUserIdItem.title ?: EMPTY
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp),
                    text = postByUserIdItem.body ?: EMPTY
                )
            }
        }
    }
}