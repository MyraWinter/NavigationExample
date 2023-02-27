package com.myra_winter.navigationexample

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.myra_winter.navigationexample.navigation.*
import com.myra_winter.navigationexample.ui.theme.NavigationExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // implement like this to see a Preview
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    // create a NavHost Controller
    val navController = rememberNavController()
    NavigationExampleTheme (darkTheme = false) {
        Scaffold(
            bottomBar = { BottomNavigationBar(navController) },
            content = { padding ->
                Box(modifier = Modifier.padding(padding)) {
                    NavigationExampleNavGraph(
                        navController = navController
                    )
                }
            }
        )
    }
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationExampleTheme {
        MyApp()
    }
}
