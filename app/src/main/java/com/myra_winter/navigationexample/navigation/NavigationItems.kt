package com.myra_winter.navigationexample.navigation

import com.myra_winter.navigationexample.R

sealed class NavigationItems(
    var bottom_route: String? = null,
    var route: String,
    var page_icon: Int,
    var page_title: String
) {
    object Home :
        NavigationItems(
            bottom_route = "home", route = "Home",
            page_icon = R.drawable.ic_home, page_title = "Home"
        )

    object Movies :
        NavigationItems(
            bottom_route = "movies", route = "Movies",
            page_icon = R.drawable.ic_movie, page_title = "Movies"
        )

    class Books {
        object Overview : NavigationItems(
            bottom_route = "book_overview", route = "Overview",
            page_icon = R.drawable.ic_pages, page_title = "Overview"
        )

        object Details : NavigationItems(
            route = "Details", page_icon = R.drawable.ic_pages, page_title = "Details"
        )
    }
}
