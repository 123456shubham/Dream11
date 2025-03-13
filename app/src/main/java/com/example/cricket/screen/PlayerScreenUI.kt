package com.example.cricket.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cricket.common.CommonImage
import com.example.cricket.common.CommonTextView


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.with
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.cricket.R
import com.example.cricket.model.Player


@Composable
fun PlayerScreen(player: Player){

    Box (modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(10.dp))){
        Column {
            Row(modifier=Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                CommonImage("", modifier = Modifier.heightIn(min=50.dp, max = 100.dp))
                Column(modifier = Modifier.fillMaxWidth().weight(2f), verticalArrangement =Arrangement.Center) {
                    CommonTextView(player.name, textAlign = TextAlign.Center)
                    CommonTextView("India", textAlign = TextAlign.Center)
                }
                CommonTextView("26", textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
                CommonTextView("8.5", textAlign = TextAlign.Center, modifier = Modifier.weight(1f))
                FlipIconButton()

            }
            Divider(color = Color.Gray, thickness = 1.dp)
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FlipIconButton() {
    var isSelected by remember { mutableStateOf(false) }

    IconButton(
        onClick = { isSelected = !isSelected },
        modifier = Modifier.size(50.dp) // Adjust button size
    ) {
        AnimatedContent(
            targetState = isSelected,
            transitionSpec = {
                fadeIn(animationSpec = tween(300)) with fadeOut(animationSpec = tween(300))
            },
            label = "Flip Animation"
        ) { state ->
            if (state) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Remove",
                    tint = MaterialTheme.colorScheme.primary
                )
            } else {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "Add",
                    tint = colorResource(R.color.pink) // ✅ Green for Add
                )
            }
        }
    }
}
