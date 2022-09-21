package com.example.teta_gradle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.teta_gradle.model.CardData
import com.example.teta_gradle.model.TapState
import com.example.teta_gradle.ui.card.view.CardContent
import com.example.teta_gradle.ui.card.view.CardList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLayout()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainLayout() {
    val state = remember {
        mutableStateOf(
            listOf(
                CardData(Color.Black, isFirst = true, {
                    CardContent(title = "title", subtitle = "subtitle", icon = Icons.Default.CheckCircle)
                }),
                CardData(Color.Blue),
                CardData(Color.Red)
            ).reversed()
        )
    }
    val tapState = remember {
        mutableStateOf(
            TapState(tapped = false, offset = Offset.Zero)
        )
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        CardList(state.value, tapState)
    }
}
