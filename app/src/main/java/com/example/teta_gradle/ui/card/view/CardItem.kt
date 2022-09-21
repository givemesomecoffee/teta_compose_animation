package com.example.teta_gradle.ui.card.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.example.teta_gradle.config.CardParams
import com.example.teta_gradle.model.CardData
import com.example.teta_gradle.model.TapState
import com.example.teta_gradle.ui.card.animation.configureAnimation
import com.example.teta_gradle.ui.card.modifier.configureCard
import com.example.teta_gradle.ui.card.provider.CardItemProvider

@Composable
fun CardItem(
    cardData: CardData,
    tapState: MutableState<TapState>,
) {
    Box(modifier = Modifier.configureCard(
        cardWidth = CardParams.CARD_WIDTH.dp,
        cardHeight = CardParams.CARD_HEIGHT.dp,
        backgroundAlfa = CardParams.BACKGROUND_OPACITY,
        color = cardData.color,
        isFirst = cardData.isFirst,
        tapState = tapState,
        configureAnimation(
            tapState = tapState,
            isFirst = cardData.isFirst,
            position = cardData.position ?: 0
        )
    )) {
        Box(modifier = Modifier.padding(5.dp)) {
            cardData.content?.invoke()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CardItemPreview(@PreviewParameter(CardItemProvider::class) cardData: Pair<CardData, TapState>) {
    val tapState = remember { mutableStateOf(cardData.second) }
    CardItem(cardData = cardData.first, tapState)
}
