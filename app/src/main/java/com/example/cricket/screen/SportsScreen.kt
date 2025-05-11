package com.example.cricket.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cricket.R
import com.example.cricket.common.CommonImage
import com.example.cricket.common.CommonTextView

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SportsScreen(){
    Box (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 0.dp, start = 10.dp, end = 10.dp, bottom = 5.dp)
        .background(color = colorResource(R.color.white))
        .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp))
        .clip(RoundedCornerShape(10.dp))){

        MatchScreen()
    }
}

@Composable
fun MatchScreen(){


        Column(modifier = Modifier.background(color = Color.White).fillMaxWidth()) {
            Row (modifier = Modifier){
                CommonTextView(
                    text = "IPL",
                    fontSize = 20.sp,
                    paddingStart = 10.dp,
                    paddingTop = 10.dp,
                    paddingBottom = 10.dp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.pink),
                    textAlign = TextAlign.Start,
                    maxLines = 2,
                )


//                CommonImage(imageUrl = "https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif", modifier = Modifier.heightIn(min=20.dp, max = 20.dp).weight(1f))


            }
//            Divider(modifier = Modifier.padding(10.dp))

            Row (modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp)){
                Column (modifier = Modifier){
                    CommonImage(imageUrl = "https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif", modifier = Modifier.heightIn(min=30.dp, max = 30.dp).width(50.dp).height(40.dp))
                    CommonTextView(
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        text = "INDIA",
                        fontSize = 14.sp,
                        paddingStart = 0.dp,
                        paddingTop = 10.dp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black),
                        textAlign = TextAlign.Center,
                        maxLines = 2,

                    )
                }

                CommonTextView(

                    text = "12 : 50 : 60",
                    fontSize = 14.sp,
                    paddingStart = 0.dp,
                    paddingTop = 10.dp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.black),
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    modifier = Modifier.weight(2f)
                )

                Column (modifier = Modifier.fillMaxWidth().weight(1f), horizontalAlignment = Alignment.End){
                    CommonImage(imageUrl = "https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif", modifier = Modifier.heightIn(min=30.dp, max = 30.dp).width(50.dp).height(40.dp).align(Alignment.End))
                    CommonTextView(
                        modifier = Modifier.align(Alignment.End).padding(end = 10.dp),
                        text = "England",
                        fontSize = 14.sp,
                        paddingTop = 10.dp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black),
                        textAlign = TextAlign.Center,
                        maxLines = 2,
                    )
                }

            }

//            Divider(modifier = Modifier.padding(10.dp))

            CommonTextView(
                text = "Mega 1CR",
                fontSize = 14.sp,
                paddingStart = 10.dp,
                paddingTop = 10.dp,
                paddingBottom = 10.dp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.black),
                textAlign = TextAlign.Start,
                maxLines = 2,
                modifier =Modifier.fillMaxWidth().background(color = colorResource(R.color.white)).shadow(elevation = 1.dp, shape = RoundedCornerShape(bottomStart = 0.dp, bottomEnd = 0.dp))
            )

        }

}