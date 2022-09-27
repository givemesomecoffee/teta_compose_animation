package com.example.teta_gradle.ui.card.provider

import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import com.example.teta_gradle.model.CardData

fun generateSampleData(count: Int): List<CardData> {
    if (count == 0) return emptyList()
    val list = mutableListOf<CardData>()
    val color = listOf(
        Color.Blue,
        Color.Red,
        Color.Green,
        Color.Magenta,
        Color.Yellow
    )
    list.add(
        CardData(
            color = Color.Black,
            isFirst = true,
            content = {
                Text(text = "super", color = Color.White)
            },
            position = count - 1
        )
    )
    for ( i in count - 1 downTo 1){
        list.add(
            CardData(
                color = color.random(),
                position = i,
            )
        )
    }

    return list.reversed()
}
