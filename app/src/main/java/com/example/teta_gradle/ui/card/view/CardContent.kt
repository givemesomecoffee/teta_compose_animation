package com.example.teta_gradle.ui.card.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CardContent(title: String?, subtitle: String?, icon: ImageVector?) {

    Column() {
        Row(
            modifier = Modifier
        ) {
            title?.let {
                Text(
                    text = it,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = Color.White,
                    modifier = Modifier.weight(1f, fill = false)
                )
            }
            icon?.let {
                Icon(
                    imageVector = it, "", modifier = Modifier.align(Alignment.CenterVertically),
                    tint = Color.White
                )
            }
        }
        subtitle?.let {
            Text(
                text = it,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
private fun CardContentPreview() {
    CardContent(
        title = "title",
        subtitle = "subtitle",
        icon = Icons.Default.CheckCircle
    )
}
