package com.myra_winter.navigationexample.navigation

import android.util.Log
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.myra_winter.navigationexample.helper.bookSamples
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
            BooksOverviewScreen(navController = navController)
        }
        composable(
            NavigationItems.Books.Details.route + "/{selected}",
            arguments = listOf(navArgument("selected") { type = NavType.IntType })
        ) { backStackEntry ->
            Log.i("NAVIGATION", "Is this called?")

            backStackEntry.arguments?.getInt("selected")?.let { bookId ->
                // get selected book here or better in viewModel? -> viewModel instead of Int a BookDbExample element should be transferred if possible
                val specificBook = bookSamples.first {
                    it.id == bookId
                }
                BooksDetailScreen(specificBook)
            }
        }

    }
}