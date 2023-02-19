package com.andres.ceiba.presentation.ui.splash.molecules

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.andres.ceiba.R
import com.andres.ceiba.data.utils.Constants

@Composable
fun ContentSplash(scale: Animatable<Float, AnimationVector1D>) {
    Spacer(modifier = Modifier)
    AnimatedVisibility(visible = true) {
        Image(
            painter = painterResource(id = R.drawable.ceiba),
            contentDescription = Constants.EMPTY,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 60.dp, top = 40.dp, end = 60.dp)
                .size(400.dp)
                .scale(scale.value)
        )
    }
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        text = stringResource(R.string.developer),
        style = MaterialTheme.typography.bodyLarge.copy(
            textAlign = TextAlign.Center,
            color = Color.White,
        )
    )
}