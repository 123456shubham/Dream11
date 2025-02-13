package com.example.cricket.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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


// common Text View for storing dynamic value
@Composable
fun CommonTextView(text: String,
                   modifier: Modifier = Modifier,
                   fontSize: TextUnit = 16.sp, // Default font size
                   fontWeight: FontWeight = FontWeight.Normal, // Default font weight
                   color: Color = Color.Black, // Default text color
                   textAlign: TextAlign? = null, // Optional text alignment
                   maxLines: Int = Int.MAX_VALUE, // Default: No line limit
                   overflow: TextOverflow = TextOverflow.Ellipsis // Handles overflow text
 ){
    Text(
        text = text,
        modifier = modifier,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )

}
