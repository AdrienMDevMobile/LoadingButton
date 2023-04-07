package com.example.loadingbutton.ui.element.doubleColorButton

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loadingbutton.ui.theme.LoadingButtonTheme


@Composable
fun DoubleColorButton(
    color1: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color2: Color? = null,
    shape: Shape = RoundedCornerShape(5),
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    elevation: ButtonElevation? = ButtonDefaults.elevation(),
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    //contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    contentPadding: PaddingValues = PaddingValues(
        start = 0.dp,
        top = 0.dp,
        end = 0.dp,
        bottom = 0.dp,
    ),
    content: @Composable RowScope.() -> Unit
) {
    Box(
        modifier = modifier.clip(shape),
        contentAlignment = Alignment.Center
    ) {
        Row(modifier = modifier) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
                    .background(color1)
            )
            Box(
                Modifier
                    .fillMaxHeight()
                    .weight(0.5f)
                    .background(color2 ?: color1)
            )
        }
        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp),
            shape = shape,
            enabled = enabled,
            interactionSource = interactionSource,
            elevation = elevation,
            colors = colors,
            contentPadding = contentPadding,
            content = content
        )
    }

}

@Preview
@Composable
fun PreviewDoubleColorButtonRedBlue() {
    LoadingButtonTheme() {
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
}

@Preview
@Composable
fun PreviewDoubleColorButtonYellow() {
    LoadingButtonTheme {
        Box(modifier = Modifier.size(100.dp)) {
            DoubleColorButton(
                color1 = Color.Yellow,
                onClick = {},
                modifier = Modifier.size(75.dp, 50.dp)
            ) {
                Text("Text")
            }
        }
    }
}
