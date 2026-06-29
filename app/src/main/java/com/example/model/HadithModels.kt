package com.example.model

data class Hadith(
    val id: Int,
    val title: String,
    val category: String,
    val arabic: String,
    val pronunciation: String,
    val translation: String,
    val reference: String
)

object HadithData {
    val hadithList = listOf<Hadith>()
}
