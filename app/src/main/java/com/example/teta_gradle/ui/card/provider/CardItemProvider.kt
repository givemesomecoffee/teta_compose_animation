package com.example.teta_gradle.ui.card.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.teta_gradle.model.CardData
import com.example.teta_gradle.model.TapState

class CardItemProvider : PreviewParameterProvider<Pair<CardData, TapState>> {
    override val values: Sequence<Pair<CardData, TapState>>
        get() = getDataSequence()
    private val cards = generateSampleData(3)

    private fun getDataSequence(): Sequence<Pair<CardData, TapState>> {
        val list = cards.map { Pair(it, TapState(false)) }.toMutableList()
        list.addAll(cards.map { Pair(it, TapState(true)) })
        return list.asSequence()
    }
}
