package com.example.teta_gradle.ui.shape

import androidx.compose.foundation.shape.GenericShape

val TiledShape = GenericShape { size, _ ->
    val angle = 5
    val cornerRadius = 40f
    val tilt = size.width * angle / 180
    val topLeftEdge = DrawPoint(0f + tilt, 0f)
    val bottomLeftEdge = DrawPoint(0f, size.height)
    val bottomRightEdge = DrawPoint(size.width, size.height)
    val topRightEdge = DrawPoint(size.width - tilt, 0f)
    topLeftEdge.apply {
        moveTo(x, y + cornerRadius)
    }
    bottomLeftEdge.apply {
        lineTo(x, y - cornerRadius)
        quadraticBezierTo(
            x1 = x,
            y1 = y,
            x2 = x + cornerRadius,
            y2 = y
        )
    }
    bottomRightEdge.apply {
        lineTo(x - cornerRadius, y)
        quadraticBezierTo(
            x1 = x,
            y1 = y,
            x2 = x,
            y2 = y - cornerRadius
        )
    }
    topRightEdge.apply {
        lineTo(
            x, y + cornerRadius
        )
        quadraticBezierTo(
            x1 = x,
            y1 = y,
            x2 = x - cornerRadius,
            y2 = y
        )
    }
    topLeftEdge.apply {
        lineTo(x + cornerRadius, y)
        quadraticBezierTo(
            x1 = x,
            y1 = y,
            x2 = x,
            y2 = y + cornerRadius
        )
    }
}
