package com.andres.ceiba.presentation.ui.main.atoms

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.andres.ceiba.R
import com.andres.ceiba.presentation.theme.GreenCeiba

@Composable
fun CustomLoading(
    context: Context,
    showProgress: Boolean,
) {
    val imgLoader = ImageLoader.Builder(context).components {
        if (Build.VERSION.SDK_INT >= 28) add(ImageDecoderDecoder.Factory()) else add(GifDecoder.Factory())
    }.build()
    val activity = context as Activity
    val window = activity.window
    val focusManager = LocalFocusManager.current
    if (showProgress) {
        focusManager.clearFocus()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(GreenCeiba.copy(alpha = 0.5f)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = R.drawable.loading,
                    imageLoader = imgLoader
                ),
                contentDescription = stringResource(R.string.loading),
                modifier = Modifier.size(80.dp)
            )
        }
    } else {
        window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
}