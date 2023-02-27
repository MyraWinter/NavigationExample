package com.myra_winter.navigationexample.helper

import androidx.annotation.DrawableRes
import com.myra_winter.navigationexample.R

data class BookDbExample(
    var title: String,
    var description: String,
    var writer: String = "",
    var genre: String = "",
    var iban: String = "",
    @DrawableRes var pic: Int = R.drawable.ic_book
)


val bookSamples = listOf(
    BookDbExample("First Title", "This is about a catching app creation which nobody should miss", "Sample Writer", "Fantasy, Action", "123-123-123"),
    BookDbExample("2nd Title", loremText),
    BookDbExample("3rd Title", "This is about a catching app creation which nobody should miss"),
    BookDbExample("4th Title", "This is about a catching app creation which nobody should miss")
)

val loremText get() = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."