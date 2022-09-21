package com.example.teta_gradle.ui.card.animation

import androidx.compose.animation.core.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.example.teta_gradle.config.CardParams
import com.example.teta_gradle.model.TapState
import com.example.teta_gradle.utils.toIntOffset

@Composable
fun configureAnimation(
    tapState: MutableState<TapState>,
    isFirst: Boolean,
    position: Int
): CardAnimationParams {
    val transition = updateTransition(tapState.value, label = "expand")
    val angle by transition.animateFloat(
        transitionSpec = { tween(1000) }, label = "changeAngle"
    ) { state ->
        if (state.tapped || isFirst) {
            0.0f
        } else {
            (CardParams.CARD_SPACER.toFloat() / CardParams.CARD_HEIGHT) * 45f// 5.0f
        }
    }
    val space by transition.animateDp(
        transitionSpec = { tween(1000) }, label = "changeSpace"
    ) { state ->
        if (state.tapped) {
            ((CardParams.CARD_HEIGHT - CardParams.CARD_SPACER) * position).dp
        } else {
            (CardParams.CARD_SPACER * position).dp
        }
    }

    val offset by transition.animateIntOffset(
        transitionSpec = {
            spring(
                dampingRatio = if (isFirst) 1f else 1.5f + (position / 2.0f)
            )
        }, label = "changeOffset"
    ) { state ->
        state.offset.toIntOffset()
    }

    return CardAnimationParams(
        topSpace = space,
        rotateAngle = angle,
        offset = offset
    )
}
