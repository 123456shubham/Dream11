package com.example.cricket.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.cricket.R

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SendOTP(){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.pink)) ){
        Column() {

            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null, modifier =Modifier)


        }
    }


}