package com.example.cricket.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.cricket.R
import com.example.cricket.common.CommonImage


@Composable
fun HomeScreen(modifier: Modifier,navController: NavController){
    Box (modifier = Modifier
        .fillMaxWidth()){
        Column {

            Column(modifier =Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.pink))) {
                Row (modifier = Modifier.padding(top = 20.dp)){

//                    CommonImage(imageUrl = "https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif", modifier = Modifier.heightIn(100.dp))

//                    CommonImage(imageUrl = "https://media.giphy.com/media/JIX9t2j0ZTN9S/giphy.gif", modifier = Modifier.heightIn(100.dp))
                }
            }
            TabLayout()

        }
    }
}


@Composable
fun TabLayout() {
    var tabIndex by remember { mutableIntStateOf(0) }

    // Tab titles
    val tabs = listOf("Cricket", "Football", "Basketball", "Hockey")

    Column(modifier = Modifier.fillMaxWidth()) {
        // TabRow
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = colorResource(id = R.color.pink),
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex]),
                    color = Color.White
                )
            },
            divider = {
                Divider(color = Color.White)
            }
        ) {
            // Creating tabs dynamically based on `tabs` list
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            title,
                            fontSize = 9.sp,
                            style = TextStyle(
                                color = if (tabIndex == index) Color.White else Color.LightGray,
                                fontWeight = if (tabIndex == index) FontWeight.Bold else FontWeight.Normal
                            )
                        )
                    },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                )
            }
        }

        // Displaying content based on selected tab
        when (tabIndex) {
            0 -> SportsScreen()
//            1 -> FootballScreen()
//            2 -> BasketballScreen()
//            3 -> HockeyScreen()
        }
    }
}