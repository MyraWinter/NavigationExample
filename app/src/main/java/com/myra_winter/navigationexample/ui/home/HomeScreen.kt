package com.myra_winter.navigationexample.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// https://developer.android.com/jetpack/compose/text

@OptIn(ExperimentalTextApi::class)
@Composable
fun HomeScreen(
) {

    val gradientColors = listOf(Cyan, Blue, Cyan, Color.LightGray, Color.Red /*...*/)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .fillMaxHeight(),
        // verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "HomeScreen",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = "This will be an App where you can add you favorite movies and books. Like this you will be able" +
                    "to have a better overview. Even more so when there are still episodes coming soo ;)",
        )
        Text(
            buildAnnotatedString {
                append("This page is also to test a few styles\n")
                withStyle(
                    SpanStyle(brush = Brush.linearGradient(colors = gradientColors))
                ) { append("because you can do so much xd") }
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(

            text = "This page is just a one-side-page without navigation on the page",
        )
    }
}

@Composable
@Preview(
    group = "Home", // in the corner you can see groups so that you do not need to render all
    // uiMode = UI_MODE_NIGHT_YES,
    name = "My Preview with changed BG",
    // showDecoration = true, ??
    // device = Devices.PIXEL_C,
    showBackground = true,
    backgroundColor = 0x989a82,
)
@Preview(
    group = "Profile",
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_UNDEFINED,
    showBackground = true
)
@Preview(group = "Profile", name = "Full Preview", showSystemUi = true)
fun HomeScreenPreview() {
    MaterialTheme {
        HomeScreen()
    }
}