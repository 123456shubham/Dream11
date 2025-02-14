package com.example.cricket.screen

import android.window.SplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cricket.R
import com.example.cricket.common.CommonImage


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreen(){

    Box(modifier = Modifier.fillMaxSize().background(color = colorResource(id = R.color.pink))) {
        CommonImage(imageUrl = "https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif", modifier = Modifier.fillMaxSize())


    }

}