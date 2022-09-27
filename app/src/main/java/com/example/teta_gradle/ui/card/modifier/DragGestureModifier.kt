package com.example.teta_gradle.ui.card.modifier

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import com.example.teta_gradle.model.TapState

fun Modifier.configureGestureCallback(
    tapState: MutableState<TapState>,
    isFirst: Boolean
): Modifier {
    return if (isFirst) {
        this.pointerInput(Unit) {
            detectDragGestures(
                onDragStart = {
                    tapState.value = tapState.value.copy(tapped = true)
                },
                onDrag = { pointer, _ ->
                    tapState.value = tapState.value.copy(offset = pointer.position)
                },
                onDragEnd = {
                    tapState.value =
                        tapState.value.copy(tapped = false, offset = Offset.Zero)
                }
            )
        }
    } else {
        this
    }
}
