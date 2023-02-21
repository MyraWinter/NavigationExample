package com.myra_winter.navigationexample.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.myra_winter.navigationexample.ui.movie.MovieScreen

fun NavGraphBuilder.addMovieTopLevel(
    modifier: Modifier,
    navController: NavController
) {
    composable(NavigationItems.Movies.route) {
        MovieScreen()
    }
}