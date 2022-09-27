package com.example.teta_gradle.ui.card.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.teta_gradle.model.CardData
import com.example.teta_gradle.model.TapState
import com.example.teta_gradle.ui.card.provider.CardListProvider

@Composable
fun CardList(state: List<CardData>, tapState: MutableState<TapState>) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box {
            state.forEachIndexed { index, card ->
                CardItem(card.copy(position = index), tapState)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CardListPreview(@PreviewParameter(CardListProvider::class) cardListData: Pair<List<CardData>, TapState>) {
    val tapState1 = remember {
        mutableStateOf(cardListData.second)
    }
    CardList(state = cardListData.first, tapState = tapState1)
}
