package com.example.loadingbutton.ui.element.loadingButton

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.progressSemantics
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate

@Composable
fun CheckMarker(
    progress: Float,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary,
) {
    Canvas( //Canvas = zone de dessin
        modifier
            .progressSemantics(value = progress) //Gère l'animation appliquée au canvas
            .fillMaxHeight()
    ) {
        drawMyCircle(progress, color)
        drawCheckSign(progress, color, top = 10f, bottom = size.height - 30)
    }
}

private fun DrawScope.drawCheckSign(
    progress: Float,
    color: Color,
    start: Float = 0f,
    end: Float= size.width,
    top: Float = 0f,
    bottom: Float = size.height,
) {
    clipPath(
        Path().apply {
            moveTo(start, top) // déplacez-vous vers le coin supérieur gauche
            lineTo(end, top) // ligne vers le coin supérieur droit
            lineTo(end / 2 - 15, bottom-10) // ligne vers le presque milieu du bas
            close() // fermer la forme pour compléter le triangle
            moveTo(start, top + 10f) //triangle gauche
            lineTo(start, bottom)
            lineTo(end / 2 - 25, bottom)
            close()
            moveTo(end, top)
            lineTo(end, bottom)
            lineTo(end / 2, bottom)
            close()
        },
        ClipOp.Difference
    ) {
        drawRect(
            color,
            Offset(start + 35f, top),
            Size(((end - start) - 35) * progress, bottom-top)
        )
    }
}

private fun DrawScope.drawMyCircle(
    progress: Float,
    color: Color,
) {
    val sweep = 360 * progress

    clipPath(
        Path().apply {
            addOval(
                Rect(
                    //Offset(size.width/2, size.height/2),
                    Offset(size.width * 0.05f, size.height * 0.05f),
                    Size(size.width * 0.9f, size.height * 0.9f)
                )
            )
        },
        ClipOp.Difference
    ) {
        drawArc(color, 0.9f, sweep, true)
    }
}