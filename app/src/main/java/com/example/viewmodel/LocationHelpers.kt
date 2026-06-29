package com.example.viewmodel

data class District(
    val name: String,
    val englishName: String,
    val lat: Double,
    val lng: Double
)

fun getDistrictsForCountry(code: String): List<District> {
    return listOf(District("Dhaka", "Dhaka", 23.8103, 90.4125))
}
