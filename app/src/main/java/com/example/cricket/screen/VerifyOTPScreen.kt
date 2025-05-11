package com.example.cricket.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cricket.R
import com.example.cricket.common.AppButton
import com.example.cricket.common.CommonImage
import com.example.cricket.common.CommonTextView
import com.example.cricket.common.OtpView
import com.example.cricket.navigation.Routes


@Composable
fun VerifyOTPScreen(modifier: Modifier,navController: NavController){

    val otp by rememberSaveable { mutableStateOf("****") }


    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.pink))){
        Column{

            CommonImage(imageUrl = "https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif")
            CommonTextView(
                text = "OTP Verification",
                modifier = Modifier.fillMaxWidth(),
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
                text = "Enter the code from the sms we want to \n +91 8571056426",
                modifier = Modifier.fillMaxWidth(),
                paddingStart = 16.dp,
                paddingEnd = 0.dp,
                paddingTop = 20.dp,
                paddingBottom = 0.dp,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                color = colorResource(id = R.color.white),
                textAlign = TextAlign.Center,
                maxLines = 2,
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))



            Spacer(modifier = Modifier.padding(top = 10.dp))

            OtpView (modifier = Modifier
                .padding(20.dp)
                .align(Alignment.CenterHorizontally), otpText = otp, colorResource(id = R.color.white),
                Color.Transparent, charSize = 20.sp, otpCount = 4
            ){
                otp
            }

//            CommonTextView(
//                text = "10",
//                modifier = Modifier.fillMaxWidth(),
//                paddingStart = 16.dp,
//                paddingEnd = 0.dp,
//                paddingTop = 20.dp,
//                paddingBottom = 0.dp,
//                fontSize = 14.sp,
//                fontWeight = FontWeight.Normal,
//                color = colorResource(id = R.color.white),
//                textAlign = TextAlign.Center,
//                maxLines = 2,
//            )
            AppButton(
                title = "Verify OTP",
                modifier = Modifier.width(300.dp).align(Alignment.CenterHorizontally),
                background = Color.White,
                textColor = Color.Black,
                paddingStart = 16.dp,
                paddingEnd = 16.dp,
                paddingTop = 16.dp,
                paddingBottom = 0.dp,
                onClick = { navController.navigate(Routes.HomeScreen) }
            )




        }

    }
}