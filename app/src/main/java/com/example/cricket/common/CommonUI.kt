package com.example.cricket.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.cricket.R
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.text.TextStyle


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


// common Text View & storing dynamic value
@Composable
fun CommonTextView( text: String,
                    modifier: Modifier = Modifier,
                    fontSize: TextUnit = 16.sp, // Default font size
                    fontWeight: FontWeight = FontWeight.Normal, // Default font weight
                    color: Color = Color.Black, // Default text color
                    textAlign: TextAlign? = null, // Optional text alignment
                    maxLines: Int = Int.MAX_VALUE, // Default: No line limit
                    overflow: TextOverflow = TextOverflow.Ellipsis, // Handles overflow text
                    paddingStart: Dp = 0.dp, // Default padding for start
                    paddingEnd: Dp = 0.dp,   // Default padding for end
                    paddingTop: Dp = 0.dp,   // Default padding for top
                    paddingBottom: Dp = 0.dp // Default padding for bottom
){
    Text(
        text = text,
        modifier = modifier.padding(start = paddingStart, end = paddingEnd, top = paddingTop, bottom = paddingBottom),

        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,

    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Enter text...",
    textColor: Color = Color.Black,
    placeholderColor: Color = Color.Gray,
    borderColor: Color = colorResource(id = R.color.pink), // Default border color
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default, // Dynamic keyboard options
    visualTransformation: VisualTransformation = VisualTransformation.None, // Allows password masking
    paddingStart: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingBottom: Dp = 0.dp
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier
            .padding(
                start = paddingStart,
                end = paddingEnd,
                top = paddingTop,
                bottom = paddingBottom
            )
            .fillMaxWidth(),
        textStyle = TextStyle(color = textColor, fontSize = 16.sp),
        placeholder = { Text(text = placeholder, color = placeholderColor) },
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation, // Handles transformations (e.g., password)
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = borderColor,  // Color when focused
            unfocusedBorderColor = borderColor // Color when not focused
        )
    )
}


@Composable
fun AppButton(
    title: String,
    paddingStart: Dp = 0.dp,
    paddingEnd: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    paddingBottom: Dp = 0.dp,
    textColor: Color = Color.White,
    background: Color = Color.Blue, // Default background color
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp), // Updated for Material3
        colors = ButtonDefaults.buttonColors(
            containerColor = background // Updated from backgroundColor
        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(
            start = paddingStart,
            end = paddingEnd,
            top = paddingTop,
            bottom = paddingBottom
        )
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                color = textColor,
                fontWeight = FontWeight.W600
            )
        )
    }
}

@Composable
fun SpacerHeight(height: Dp = 5.dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerWidth(width: Dp = 5.dp) {
    Spacer(modifier = Modifier.width(width))
}
