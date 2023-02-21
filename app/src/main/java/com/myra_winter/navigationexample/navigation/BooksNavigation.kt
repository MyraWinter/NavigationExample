package com.myra_winter.navigationexample.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.myra_winter.navigationexample.ui.books.detail.BooksDetailScreen
import com.myra_winter.navigationexample.ui.books.overview.BooksOverviewScreen

fun NavGraphBuilder.addBooksTopLevel(
    modifier: Modifier,
    navController: NavController
) {
    navigation(
        route = NavigationItems.Books.Overview.bottom_route!!,
        startDestination = NavigationItems.Books.Overview.route
    ) {
        composable(NavigationItems.Books.Overview.route) {
            BooksOverviewScreen(navigateToDetail = { navController.navigate(NavigationItems.Books.Details.route) })
        }
        composable(NavigationItems.Books.Details.route) {
            BooksDetailScreen()
        }
    }
}