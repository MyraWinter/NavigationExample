package com.myra_winter.navigationexample.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.compose.currentBackStackEntryAsState
import com.myra_winter.navigationexample.R
import com.myra_winter.navigationexample.navigation.NavigationItems.Books.Details.route


@Composable
fun BottomNavigationBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: NavigationItems.Home

    val bottomTabList = listOf(
        NavigationItems.Home,
        NavigationItems.Movies,
        NavigationItems.Books.Overview
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.purple_200),
        contentColor = Color.White
    ) {
        bottomTabList.forEach { tab ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = tab.page_icon), contentDescription = tab.page_title) },
                label = { Text(text = tab.page_title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == tab.route,
                onClick = {
                    navController.navigate(tab.route?: NavigationItems.Home.route) {
                        // Pop up to start dest of graph (if exists) => avoids building up a
                        // large stack of dest's on the back stack
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // avoids multiple copies of same dest's when selecting same tab again
                        launchSingleTop = true
                        // restore state when again selecting a previously selected tab
                        restoreState = true




                    }
                }
            )
        }
    }
}

private tailrec fun findStartDestination(graph: NavDestination): NavDestination {
    return if (graph is NavGraph) findStartDestination(graph.startDestination!!) else graph
}

private val NavGraph.startDestination: NavDestination?
    get() = findNode(startDestinationId)

private fun findTabRootRoute(tab: String): String {
    return when (tab) {
        NavigationItems.Home.bottom_route -> NavigationItems.Home.route
        NavigationItems.Books.Overview.bottom_route -> NavigationItems.Books.Overview.route
        NavigationItems.Movies .bottom_route -> NavigationItems.Movies.route
        else -> NavigationItems.Home.route
    }
}