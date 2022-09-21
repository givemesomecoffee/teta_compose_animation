package com.example.teta_gradle.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class CardData(
    val color: Color,
    val isFirst: Boolean = false,
    val content: @Composable (() -> Unit)? = null,
    val position: Int? = null
)
