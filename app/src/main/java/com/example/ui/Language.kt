package com.example.ui
import androidx.compose.runtime.compositionLocalOf

class AppStrings(
    val forbidden_times: String = "Forbidden Times",
    val sunrise: String = "Sunrise",
    val noon: String = "Noon",
    val sunset: String = "Sunset",
    val settings: String = "Settings"
)

val LocalAppStrings = compositionLocalOf { AppStrings() }

fun getString(lang: String): AppStrings {
    return AppStrings()
}
