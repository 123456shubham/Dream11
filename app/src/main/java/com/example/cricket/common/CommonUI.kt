package com.example.cricket.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.cricket.R



// common Image function for loading SVG File and GIF file
@Composable
fun CommonImage(
    imageUrl: String,
    contentDescription: String? = null,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 100.dp, max = 300.dp) // Default flexible height
        .clip(RoundedCornerShape(8.dp))
) {
    Image(
        painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .placeholder(R.drawable.ic_launcher_foreground) // Replace with your drawable
                .error(R.drawable.ic_launcher_foreground) // Replace with your error drawable
                .build()
        ),
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}
