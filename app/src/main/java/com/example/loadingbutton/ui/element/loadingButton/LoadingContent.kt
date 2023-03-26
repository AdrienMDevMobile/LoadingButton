package com.example.loadingbutton.ui.element.loadingButton

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaitingContent() {
    //Text(text = "Waiting")
}

@Composable
fun LoadingContent(
    modifier: Modifier = Modifier,
    contentColor : Color = Color.White
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        CircularProgressIndicator(
            color = contentColor,
            strokeWidth = 5.dp,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = "Loading", color = contentColor, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun FinishedContent(
    modifier: Modifier,
    contentColor: Color = Color.White
) {

}

@Preview
@Composable
fun PreviewLoadingContent(){
    LoadingContent()
}