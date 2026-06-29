package com.example.model

data class Dua(
    val id: String,
    val title: String,
    val category: String,
    val arabic: String,
    val pronunciation: String,
    val translation: String,
    val reference: String
)

object DuaData {
    val duaList = listOf<Dua>()
}
