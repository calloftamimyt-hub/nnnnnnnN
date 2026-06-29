package com.example.model
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    val name: String,
    val code: String,
    val language: String,
    val flag: String
)

object CountryData {
    val countries = listOf(
        Country("Bangladesh", "BD", "Bengali", "🇧🇩")
    )
}

@Serializable
data class UserProfile(
    val id: String = "",
    val queue: Int = 0,
    val data1: String = ""
)

@Serializable
data class CircleAlert(
    val docId: String = "",
    val title: String = "",
    val description: String = "",
    val mediaUri: String = "",
    val mediaType: String = "",
    val contactNumber: String = "",
    val country: String = "",
    val location: String = "",
    val timestamp: Long = 0L,
    val status: String = "PENDING"
)
