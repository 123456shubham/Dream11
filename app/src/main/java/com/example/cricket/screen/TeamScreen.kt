package com.example.cricket.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cricket.R
import com.example.cricket.common.*
import com.example.cricket.model.Player

@SuppressLint("SuspiciousIndentation")
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TeamScreen() {

    val sportsTabs = listOf("WK", "BAT", "ALL", "BOWL")
    var selectedTab by rememberSaveable { mutableStateOf(0) }

    // Sample Player List
    val allPlayers = listOf(
        Player("MS Dhoni", "WK"), Player("Rishabh Pant", "WK"),
        Player("Virat Kohli", "BAT"), Player("Rohit Sharma", "BAT"),
        Player("Hardik Pandya", "ALL"), Player("Ben Stokes", "ALL"),
        Player("Jasprit Bumrah", "BOWL"), Player("Pat Cummins", "BOWL")
    )

    // Recompute the filtered players whenever the selected tab changes
    val filteredPlayers by remember(selectedTab) {
        derivedStateOf {
            allPlayers.filter { it.role.equals(sportsTabs[selectedTab], ignoreCase = true) }
        }
    }

    Box(modifier = Modifier.fillMaxSize().padding(top = 0.dp)) {
        Column {
            // Top Header
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.pink))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.ArrowBack, contentDescription = null,
                        modifier = Modifier.padding(start = 10.dp),
                        tint = colorResource(R.color.white)
                    )
                    Spacer(modifier = Modifier.width(10.dp)) // Space between Icon and Text

                    Column(modifier = Modifier.padding(10.dp)) {
                        CommonTextView(
                            "Create Team", fontWeight = FontWeight.Bold,
                            fontSize = 18.sp, color = colorResource(R.color.white)
                        )
                        CommonTextView(
                            "1h 05m left", fontWeight = FontWeight.Normal,
                            fontSize = 14.sp, color = colorResource(R.color.white)
                        )
                    }
                }

                // Match Teams & Timer
                Row(
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    CommonImage(
                        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/b/bc/Flag_of_India.png",
                        modifier = Modifier.heightIn(min = 50.dp, max = 50.dp).width(50.dp).height(50.dp)
                    )
                    CommonTextView(
                        "Ind", paddingStart = 10.dp, paddingEnd = 10.dp,
                        textAlign = TextAlign.Center, color = Color.White,
                        fontSize = 16.sp, fontWeight = FontWeight.Bold
                    )
                    CommonTextView(
                        "-", paddingStart = 10.dp, paddingEnd = 10.dp,
                        textAlign = TextAlign.Center, color = Color.White,
                        fontSize = 24.sp, fontWeight = FontWeight.Bold
                    )
                    CommonTextView(
                        "Pak", paddingStart = 10.dp, paddingEnd = 10.dp,
                        textAlign = TextAlign.Center, color = Color.White,
                        fontSize = 16.sp, fontWeight = FontWeight.Bold
                    )
                    CommonImage(
                        imageUrl = "https://upload.wikimedia.org/wikipedia/commons/b/bc/Flag_of_India.png",
                        modifier = Modifier.heightIn(min = 50.dp, max = 50.dp).width(50.dp).height(50.dp)
                    )
                }

                // Selected Players Count
                Row(
                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.Center,
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp, bottom = 10.dp),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    CommonTextView(
                        "5/11", paddingStart = 10.dp, paddingEnd = 1.dp,
                        textAlign = TextAlign.Center, color = Color.White,
                        fontSize = 16.sp, fontWeight = FontWeight.Bold
                    )
                    DynamicSelectableImages(total = 11, selectedCount = 5)
                }
            }

            // Tab Screens
            val sportsScreens: List<@Composable () -> Unit> = sportsTabs.mapIndexed { index, _ ->
                {
                    LazyColumn {
                        items(filteredPlayers) { player ->
                            PlayerScreen(player)
                        }
                    }
                }
            }

            // Common Tab Layout
            CommonTabLayout(
                tabs = sportsTabs,
                screens = sportsScreens,
                selectedTabIndex = selectedTab,
                onTabSelected = { selectedTab = it }
            )
        }
    }
}
