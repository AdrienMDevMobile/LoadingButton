package com.example.loadingbutton.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.loadingbutton.ui.element.doubleColorButton.DoubleColorButton

@Composable
fun DoubleColorButtonPresentation(){
    Box(modifier = Modifier.size(100.dp)) {
        DoubleColorButton(
            color1 = Color.Red,
            color2 = Color.Blue,
            onClick = {}, modifier = Modifier.size(50.dp, 75.dp)
        ) {
            Text("Text")
        }
    }
}