package com.example.teta_gradle.ui.card.modifier

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.teta_gradle.model.TapState
import com.example.teta_gradle.ui.card.animation.CardAnimationParams
import com.example.teta_gradle.ui.shape.TiledShape

fun Modifier.configureCard(
    cardWidth: Dp,
    cardHeight: Dp,
    backgroundAlfa: Float,
    color: Color,
    isFirst: Boolean,
    tapState: MutableState<TapState>,
    animationParams: CardAnimationParams
): Modifier {
    return this
        .padding(top = animationParams.topSpace)
        .size(cardWidth, cardHeight)
        .rotate(animationParams.rotateAngle)
        .offset { animationParams.offset }
        .background(
            color = color.copy(backgroundAlfa),
            shape = if (tapState.value.tapped && !isFirst) {
                TiledShape
            } else {
                RoundedCornerShape(corner = CornerSize(10.dp))
            }
        )
        .configureGestureCallback(tapState, isFirst)
}
