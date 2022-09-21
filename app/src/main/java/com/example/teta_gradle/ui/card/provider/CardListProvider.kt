package com.example.teta_gradle.ui.card.provider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.teta_gradle.model.CardData
import com.example.teta_gradle.model.TapState

class CardListProvider : PreviewParameterProvider<Pair<List<CardData>, TapState>> {
    private val cardList = generateSampleData(3)
    private val cardListBig = generateSampleData(10)
    override val values: Sequence<Pair<List<CardData>, TapState>>
        get() = sequenceOf(
            Pair(cardList, TapState(false)),
            Pair(cardList, TapState(true)),
            Pair(cardListBig, TapState(false)),
            Pair(cardListBig, TapState(true)),
        )
}
