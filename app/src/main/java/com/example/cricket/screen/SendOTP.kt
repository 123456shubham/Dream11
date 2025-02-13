package com.example.cricket.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cricket.R
import com.example.cricket.common.AppButton
import com.example.cricket.common.CommonImage
import com.example.cricket.common.CommonTextField
import com.example.cricket.common.CommonTextView

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SendOTP(){

    val mobileNumber = rememberSaveable { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(colorResource(id = R.color.pink)) ){
        Column{

            CommonImage(imageUrl = "https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif")
            CommonTextView(
                text = "Verify your Mobile Number",
                paddingStart = 16.dp,
                paddingEnd = 0.dp,
                paddingTop = 6.dp,
                paddingBottom = 0.dp,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                maxLines = 2,
            )

            CommonTextView(
                text = "We have send you OTP on this mobile number",
                paddingStart = 16.dp,
                paddingEnd = 0.dp,
                paddingTop = 20.dp,
                paddingBottom = 0.dp,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                maxLines = 2,
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))


            CommonTextField(
                value = mobileNumber.value,
                onValueChange = { newText ->
                    if (newText.all { it.isDigit() }) { // Allow only numeric input
                        mobileNumber.value = newText
                    }
                },
                placeholder = "Enter Mobile Number",
                placeholderColor = colorResource(id = R.color.white),
                textColor = colorResource(id = R.color.white),
                borderColor = colorResource(id = R.color.white),
                paddingStart = 16.dp,
                paddingEnd = 16.dp,
                paddingTop = 26.dp,
                paddingBottom = 0.dp,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))
            AppButton(
                title = "Send OTP",
                background = Color.White,
                textColor = Color.Black,
                paddingStart = 16.dp,
                paddingEnd = 16.dp,
                paddingTop = 16.dp,
                paddingBottom = 0.dp,
                onClick = { /* Submit Action */ }
            )

        }
    }


}