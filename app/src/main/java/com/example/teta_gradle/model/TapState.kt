package com.example.teta_gradle.model

import androidx.compose.ui.geometry.Offset

data class TapState(
    val tapped: Boolean,
    val offset: Offset = Offset.Zero
)
