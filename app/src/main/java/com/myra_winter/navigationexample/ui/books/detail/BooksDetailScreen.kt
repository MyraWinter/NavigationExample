package com.myra_winter.navigationexample.ui.books.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextGeometricTransform
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myra_winter.navigationexample.helper.BookDbExample
import com.myra_winter.navigationexample.helper.bookSamples

@Composable
fun BooksDetailScreen(specificBook: BookDbExample) {
    var modifier: Modifier = Modifier.padding(8.dp)

    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
    ) {
        Text(
            text = specificBook.title,
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily.Monospace,
                letterSpacing = 4.sp,
                textAlign = TextAlign.Center,
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(8f, 8f),
                    blurRadius = 4f
                ),
                textGeometricTransform = TextGeometricTransform(
                    scaleX = 1.5f,
                    skewX = -0.2f
                )
            ),
            modifier = modifier.fillMaxWidth()
        )
        Text(
            // justify text?
            modifier = modifier,
            text = specificBook.description
        )
        if (specificBook.iban != "") {
            Row(modifier = modifier) {
                Text(
                    text = "IBAN: "
                )
                Text(
                    text = specificBook.iban
                )
            }
        }
    }
}

@Composable
@Preview
fun BooksDetailScreenPreview() {
    MaterialTheme {
        BooksDetailScreen(bookSamples.first())
    }
}