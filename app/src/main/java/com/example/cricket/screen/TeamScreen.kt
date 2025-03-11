package com.example.cricket.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.example.cricket.common.DynamicSelectableImages


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TeamScreen(){
//    var selectedCount by rememberSaveable   { mutableStateOf(5) } // Change dynamically


        Box(modifier = Modifier.fillMaxSize().padding(top=50.dp)){

            Column(modifier = Modifier.fillMaxWidth().background(colorResource(R.color.pink))) {
                Row (modifier = Modifier.fillMaxWidth(),verticalAlignment = androidx.compose.ui.Alignment.CenterVertically){
                    Icon(Icons.Default.ArrowBack,contentDescription = null, modifier = Modifier.padding(start = 10.dp),
                        colorResource(R.color.white)
                    )
                    Spacer(modifier = Modifier.width(10.dp)) // Space between Icon and Text

                    Column (modifier = Modifier.padding(10.dp)){
                        CommonTextView("Create Team", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = colorResource( R.color.white))
                        CommonTextView("1h 05m left", fontWeight = FontWeight.Normal, fontSize = 14.sp, color = colorResource(R.color.white))

                    }
                }
                Row (horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center,modifier = Modifier.fillMaxWidth().padding(top = 10.dp),verticalAlignment = androidx.compose.ui.Alignment.CenterVertically){

                    CommonImage(imageUrl = "https://upload.wikimedia.org/wikipedia/commons/b/bc/Flag_of_India.png", modifier = Modifier.heightIn(min=50.dp, max = 50.dp))
                    CommonTextView("Ind", paddingStart = 10.dp, paddingEnd = 10.dp, textAlign = TextAlign.Center, color = Color.White,fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier)
                    CommonTextView("-", paddingStart = 10.dp, paddingEnd = 10.dp, textAlign = TextAlign.Center, color = Color.White,fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier)
                    CommonTextView("Pak", paddingStart = 10.dp, paddingEnd = 10.dp, textAlign = TextAlign.Center, color = Color.White,fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier)
                    CommonImage(imageUrl = "https://upload.wikimedia.org/wikipedia/commons/b/bc/Flag_of_India.png", modifier = Modifier.heightIn(min=50.dp, max = 50.dp))

                }
                Row (horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center,modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),verticalAlignment = androidx.compose.ui.Alignment.CenterVertically){
                    CommonTextView("5/11", paddingStart = 10.dp, paddingEnd = 1.dp, textAlign = TextAlign.Center, color = Color.White,fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier)
                    DynamicSelectableImages(total = 11, selectedCount = 5)

                }

//                Button(onClick = { selectedCount = (selectedCount + 1) % 11 }) {
//                    Text("Change Selection")
//                }
            }


    }

}











