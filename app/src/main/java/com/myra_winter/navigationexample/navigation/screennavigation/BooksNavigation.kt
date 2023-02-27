package com.myra_winter.navigationexample.navigation

import android.util.Log
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
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

//        composable(
//            NavigationItem.Books.Details.route + "/{selected}",
//            arguments = listOf(navArgument("selected") { type = NavType.IntType })
//        ) { backStackEntry ->
//            Log.i("NAVIGATION", "Is this called?")
//
//            backStackEntry.arguments?.getInt("selected")?.let { book ->
//                // get selected book here or better in viewModel?
//                val specificBook = bookSamples.first {
//                    Log.i("NAVIGATION", "Is this called?  ${it.title} &  $news")
//                    it.identifier == book }
//                BooksDetailScreen(specificBook)
//            }
//        }

    }
}