package com.myra_winter.navigationexample.ui.books.overview

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.myra_winter.navigationexample.R
import com.myra_winter.navigationexample.helper.BookDbExample
import com.myra_winter.navigationexample.helper.bookSamples
import com.myra_winter.navigationexample.navigation.NavigationItems

@Composable
fun BooksOverviewScreen(
    navController: NavController,

) {
    // this should be fetched from a viewModel
    val books: List<BookDbExample> = bookSamples
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_200))
        //.wrapContentSize(Alignment.Center)
    ) {
        items(books.size) { bookSize ->
            BookItem(
                book = books[bookSize],
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 32.dp)
                    .padding(8.dp)
                    .clickable { },
                onItemClick = { selectedBook ->
                    navController.navigate(NavigationItems.Books.Details.route + "/$selectedBook") {
                        // Pop up to the start destination of the graph to avoid building up a large stack of destinations  on the back stack as users select items
                        popUpTo(NavigationItems.Books.Overview.route) { saveState = true }
                        // Avoid multiple copies of the same destination when reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun BookItem(
    book: BookDbExample,
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier.border(BorderStroke(1.dp, Color.White), RoundedCornerShape(10.dp)),
        elevation = 10.dp,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(book.pic),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .background(color = Color.DarkGray)
                    .padding(start = 8.dp, end = 8.dp)
            )
            Column(
                modifier = Modifier
                // .fillMaxWidth()
            ) {
                Text(
                    text = book.title,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.width(width = 8.dp))
                Text(
                    text = book.writer,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }
            Spacer(Modifier.weight(1f))
            Image(
                painter = painterResource(R.drawable.ic_arrow_right),
                contentDescription = "open detail view",
                modifier = Modifier
                    .size(48.dp)
                    .fillMaxHeight()
                    .clickable(onClick = { onItemClick(book.id) })
                    //.background(color = Color(R.color.colorAccent))
                    .padding(horizontal = 8.dp)
            )
        }
    }

}


@Composable
@Preview
fun BooksOverviewScreenPreview() {
    val navController = rememberNavController()
    MaterialTheme {
        BooksOverviewScreen(navController = navController)
    }
}